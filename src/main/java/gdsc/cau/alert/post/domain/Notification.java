package gdsc.cau.alert.post.domain;

import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String title;

    private String content;

    public static Notification createNotification(Post post, String title, String content) {
        Notification notification = new Notification();
        notification.post = post;
        notification.title = title;
        notification.content = content;
        return notification;
    }
}
