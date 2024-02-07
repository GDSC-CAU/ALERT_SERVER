package gdsc.cau.alert.user.repository;

import gdsc.cau.alert.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
