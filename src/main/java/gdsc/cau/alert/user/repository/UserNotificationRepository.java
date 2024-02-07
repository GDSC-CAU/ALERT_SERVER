package gdsc.cau.alert.user.repository;

import gdsc.cau.alert.user.domain.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {

    List<UserNotification> findByUserId(Long userId);
    boolean existsByUserIdAndNotificationId(Long userId, Long notificationId);
    void deleteByUserIdAndNotificationId(Long userId, Long notificationId);
}
