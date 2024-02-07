package gdsc.cau.alert.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserDto {

    private String name;
    private String phone;
    private String address1;
    private String address2;
}
