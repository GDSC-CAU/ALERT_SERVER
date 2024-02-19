package gdsc.cau.alert.post.repository;

import gdsc.cau.alert.post.domain.Post;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    @BatchSize(size = 50)
    Page<Post> findByOrderByCreatedAtDesc(Pageable pageable);

    @BatchSize(size = 50)
    Page<Post> findByLocationOrderByCreatedAtDesc(String location, Pageable pageable);

    @BatchSize(size = 50)
    Page<Post> findBySpeciesOrderByCreatedAtDesc(String species, Pageable pageable);

    boolean existsByIdAndUserId(Long postId, Long userId);
}
