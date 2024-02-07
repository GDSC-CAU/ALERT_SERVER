package gdsc.cau.alert.animal.service;

import gdsc.cau.alert.animal.dto.CreateAnimalDto;
import gdsc.cau.alert.animal.dto.ResponseAnimalDto;
import gdsc.cau.alert.animal.dto.UpdateAnimalDto;
import org.springframework.data.domain.Page;

public interface AnimalService {

    // 동물 신규 생성
    Long createAnimal(CreateAnimalDto createAnimalDto);

    // 동물정보 수정
    void updateAnimal(UpdateAnimalDto createAnimalDto);

    // 동물정보 삭제
    void deleteAnimal(Long animalId);

    // 동물정보 전체 조회 (페이징)
    Page<ResponseAnimalDto> getAllAnimals(int page, int size);

    // 동물정보 종별로 조회 (페이징)
    Page<ResponseAnimalDto> getAnimalsBySpecies(String species, int page, int size);

    // 동물정보 상태별로 조회 (페이징)
    Page<ResponseAnimalDto> getAnimalsByType(String type, int page, int size);

    // 동물정보 이름으로 조회 (페이징)
    Page<ResponseAnimalDto> getAnimalsContainingName(String name, int page, int size);

    // 특정 동물 상세 조회
    ResponseAnimalDto getSingleAnimal(Long animalId);
}
