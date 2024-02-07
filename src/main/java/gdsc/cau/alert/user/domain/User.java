package gdsc.cau.alert.user.domain;

import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String phone;

    private String address1;

    private String address2;

    private int type;

    public static User createUser(String name, String address1, String address2, int type) {
        User user = new User();
        user.name = name;
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
}
