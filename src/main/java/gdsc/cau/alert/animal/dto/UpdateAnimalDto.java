package gdsc.cau.alert.animal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAnimalDto {

    private Long id;
    private String name;
    private String photoUrl;
    private String description;
    private String mainLocation;
    private String link;
}
