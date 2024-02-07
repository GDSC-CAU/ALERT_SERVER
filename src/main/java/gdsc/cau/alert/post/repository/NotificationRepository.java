package gdsc.cau.alert.post.repository;

import gdsc.cau.alert.post.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
