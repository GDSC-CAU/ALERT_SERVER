package gdsc.cau.alert.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseJwtDto {

    private String accessToken;
}
