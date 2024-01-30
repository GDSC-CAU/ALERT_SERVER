package gdsc.cau.alert.post.domain;

import gdsc.cau.alert.user.domain.User;
import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    private LocalDateTime capturedAt; // 촬영일시

    private String address1;

    private String address2;

    public static Post createPost(String imageUrl, User user, String title, String content, String address1, String address2) {
        Post post = new Post();
        post.imageUrl = imageUrl;
        post.user = user;
        post.title = title;
        post.content = content;
        post.address1 = address1;
        post.address2 = address2;
        return post;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
