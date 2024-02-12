package gdsc.cau.alert.user.domain;

import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
@Entity
public class User extends BaseEntity implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String uid;

    private String name;

    private String phone;

    private String address1;

    private String address2;

    private int type; // 0: 일반 사용자, 1: 관리자

    public static User createUser(String name, String uid, String address1, String address2, int type) {
        User user = new User();
        user.name = name;
        user.uid = uid;
        user.address1 = address1;
        user.address2 = address2;
        user.type = type;
        return user;
    }

    public void update(String name, String address1, String address2) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
    }

    // Jwt 전용 설정 (UserDetails 인터페이스 구현)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
