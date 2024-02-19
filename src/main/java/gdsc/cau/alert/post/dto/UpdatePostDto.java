package gdsc.cau.alert.post.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePostDto {

    private Long postId;
    private String title;
    private String content;
    private String image;
}
