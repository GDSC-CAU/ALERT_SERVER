package gdsc.cau.alert.animal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseAnimalDto {

    private String name;
    private String species;
    private String photoUrl;
    private String description;
    private String mainLocation;
    private String type;
    private String link;
}
