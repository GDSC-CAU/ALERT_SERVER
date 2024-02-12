package gdsc.cau.alert.user.repository;

import gdsc.cau.alert.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByUid(String uid);
    Optional<User> findByUid(String uid);
}
