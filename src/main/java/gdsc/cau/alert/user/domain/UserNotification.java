package gdsc.cau.alert.user.domain;

import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(UserNotification.PK.class) // 복합키 클래스
@Getter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "notification_id"})
})
@Entity
public class UserNotification extends BaseEntity {

    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "notification_id", insertable = false, updatable = false)
    private Long notificationId;

    private boolean isRead;

    public static UserNotification createUserNotification(Long userId, Long notificationId, boolean isRead) {
        UserNotification userNotification = new UserNotification();
        userNotification.userId = userId;
        userNotification.notificationId = notificationId;
        userNotification.isRead = isRead;
        return userNotification;
    }

    public static class PK implements Serializable {
        Long userId;
        Long notificationId;
    }
}
