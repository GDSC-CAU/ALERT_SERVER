package gdsc.cau.alert.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserNotificationDto {

    private String title;
    private String content;
    private String datetime;
    private String isRead;
    private String createdAt;
}
