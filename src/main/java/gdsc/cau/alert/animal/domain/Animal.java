package gdsc.cau.alert.animal.domain;

import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Animal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long id;

    private String name;

    private String species; // 종

    private String photoUrl; // 이미지 URL

    private String description; // 설명

    private String mainLocation; // 주요 서식지

    private String type; // 멸종위기종 or 교란종

    private String link; // 동물 상세 정보 링크

    public static Animal createAnimal(String name, String species, String photoUrl, String description, String mainLocation, String type, String link) {
        Animal animal = new Animal();
        animal.name = name;
        animal.species = species;
        animal.photoUrl = photoUrl;
        animal.description = description;
        animal.mainLocation = mainLocation;
        animal.type = type;
        animal.link = link;
        return animal;
    }

    public void updateAnimal(String name, String photoUrl, String description, String mainLocation, String link) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.description = description;
        this.mainLocation = mainLocation;
        this.link = link;
    }
}
