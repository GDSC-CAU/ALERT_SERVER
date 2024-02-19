package gdsc.cau.alert.post.service;

import gdsc.cau.alert.post.domain.Post;
import gdsc.cau.alert.post.domain.Vote;
import gdsc.cau.alert.post.dto.CreatePostDto;
import gdsc.cau.alert.post.dto.ResponsePostDto;
import gdsc.cau.alert.post.dto.UpdatePostDto;
import gdsc.cau.alert.post.repository.PostRepository;
import gdsc.cau.alert.post.repository.VoteRepository;
import gdsc.cau.alert.user.domain.User;
import gdsc.cau.alert.user.repository.UserRepository;
import gdsc.cau.alert.util.api.ResponseCode;
import gdsc.cau.alert.util.exception.PostException;
import gdsc.cau.alert.util.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<ResponsePostDto> getPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findByOrderByCreatedAtDesc(pageable);
        return posts.map(ResponsePostDto::of);
    }

    @Transactional(readOnly = true)
    public ResponsePostDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostException(ResponseCode.POST_NOT_FOUND));
        return ResponsePostDto.of(post);
    }

    @Transactional(readOnly = true)
    public Page<ResponsePostDto> getPostsByLocation(String location, Pageable pageable) {
        Page<Post> posts = postRepository.findByLocationOrderByCreatedAtDesc(location, pageable);
        return posts.map(ResponsePostDto::of);
    }

    @Transactional(readOnly = true)
    public Page<ResponsePostDto> getPostsBySpecies(String species, Pageable pageable) {
        Page<Post> posts = postRepository.findBySpeciesOrderByCreatedAtDesc(species, pageable);
        return posts.map(ResponsePostDto::of);
    }

    @Transactional
    public Long createPost(Long userId, CreatePostDto dto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException(ResponseCode.USER_NOT_FOUND));
        Post post = Post.createPost(user, dto.getTitle(), dto.getContent(), dto.getLocation(), dto.getCapturedAt(), dto.getImage(), dto.getSpecies());
        return postRepository.save(post).getId();
    }

    @Transactional
    public void updatePost(Long userId, UpdatePostDto dto) {
        validatePostOwner(userId, dto.getPostId());
        Post post = postRepository.findById(dto.getPostId()).orElseThrow(() -> new PostException(ResponseCode.POST_NOT_FOUND));
        post.update(dto.getTitle(), dto.getContent());
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long userId, Long postId) {
        validatePostOwner(userId, postId);
        postRepository.deleteById(postId);
    }

    @Transactional
    public void voteTruth(Long userId, Long postId) {
        if (existsVote(userId, postId)) {
            throw new PostException(ResponseCode.ALREADY_VOTED);
        }
        voteRepository.save(Vote.createVote(postId, userId, true));
    }

    @Transactional
    public void voteFake(Long userId, Long postId) {
        if (existsVote(userId, postId)) {
            throw new PostException(ResponseCode.ALREADY_VOTED);
        }
        voteRepository.save(Vote.createVote(postId, userId, false));
    }

    @Transactional
    public void cancelVote(Long userId, Long postId) {
        if (!existsVote(userId, postId)) {
            throw new PostException(ResponseCode.NOT_VOTED);
        }
        voteRepository.deleteByPostIdAndUserId(postId, userId);
    }

    private void validatePostOwner(Long userId, Long postId) {
        if (!postRepository.existsByIdAndUserId(postId, userId)) {
            throw new PostException(ResponseCode.FORBIDDEN);
        }
    }

    private boolean existsVote(Long userId, Long postId) {
        return voteRepository.existsByPostIdAndUserId(postId, userId);
    }
}
