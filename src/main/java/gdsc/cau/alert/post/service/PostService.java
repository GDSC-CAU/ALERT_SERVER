package gdsc.cau.alert.post.service;

import gdsc.cau.alert.post.dto.CreatePostDto;
import gdsc.cau.alert.post.dto.ResponsePostDto;
import gdsc.cau.alert.post.dto.UpdatePostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    // 전체 신고 게시물 조회
    Page<ResponsePostDto> getPosts(Pageable pageable);

    // 신고 게시물 상세 조회
    ResponsePostDto getPost(Long postId);

    // 내 지역의 신고 게시물 조회
    Page<ResponsePostDto> getPostsByLocation(String location, Pageable pageable);

    // 특정 종의 신고 게시물 조회
    Page<ResponsePostDto> getPostsBySpecies(String species, Pageable pageable);

    // 게시물 생성
    Long createPost(Long userId, CreatePostDto dto);

    // 게시물 수정
    void updatePost(Long userId, UpdatePostDto dto);

    // 게시물 삭제
    void deletePost(Long userId, Long postId);

    // 게시물에 해당 동물 진위여부 투표 찬성
    void voteTruth(Long userId, Long postId);

    // 게시물에 해당 동물 진위여부 투표 반대
    void voteFake(Long userId, Long postId);

    // 게시물에 해당 동물 진위여부 투표 취소
    void cancelVote(Long userId, Long postId);
}
