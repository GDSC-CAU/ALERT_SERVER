package gdsc.cau.alert.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserDto {

    private String uid;
    private String userName;
    private String address1;
    private String address2;
    private String phone;
    private int type;
}
