package gdsc.cau.alert.user.domain;

import gdsc.cau.alert.post.domain.Notification;
import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class UserNotification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_notification_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id")
    private Notification notification;

    private boolean isRead;

    public static UserNotification createUserNotification(User user, Notification notification) {
        UserNotification userNotification = new UserNotification();
        userNotification.user = user;
        userNotification.notification = notification;
        userNotification.isRead = false;
        return userNotification;
    }
}
