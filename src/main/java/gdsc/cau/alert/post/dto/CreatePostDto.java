package gdsc.cau.alert.post.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePostDto {

    private String title;
    private String content;
    private String location;
    private String capturedAt;
    private String image;
    private String species;
}
