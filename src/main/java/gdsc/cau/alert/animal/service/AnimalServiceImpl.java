package gdsc.cau.alert.animal.service;

import gdsc.cau.alert.animal.domain.Animal;
import gdsc.cau.alert.animal.dto.CreateAnimalDto;
import gdsc.cau.alert.animal.dto.ResponseAnimalDto;
import gdsc.cau.alert.animal.dto.UpdateAnimalDto;
import gdsc.cau.alert.animal.repository.AnimalRepository;
import gdsc.cau.alert.util.api.ResponseCode;
import gdsc.cau.alert.util.exception.AnimalException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    // 동물 신규 생성
    @Transactional
    public Long createAnimal(CreateAnimalDto dto) {
        Animal animal = Animal.createAnimal(dto.getName(),
                dto.getSpecies(),
                dto.getPhotoUrl(),
                dto.getDescription(),
                dto.getMainLocation(),
                dto.getType(),
                dto.getLink());
        return animalRepository.save(animal).getId();
    }

    // 동물정보 수정
    @Transactional
    public void updateAnimal(UpdateAnimalDto dto) {
        Animal animal = animalRepository.findById(dto.getId()).orElseThrow(() -> new AnimalException(ResponseCode.ANIMAL_NOT_FOUND));
        animal.updateAnimal(dto.getName(),
                dto.getPhotoUrl(),
                dto.getDescription(),
                dto.getMainLocation(),
                dto.getLink());
        animalRepository.save(animal);
    }

    // 동물정보 삭제
    @Transactional
    public void deleteAnimal(Long animalId) {
        if (!animalRepository.existsById(animalId)) {
            throw new AnimalException(ResponseCode.ANIMAL_NOT_FOUND);
        }
        animalRepository.deleteById(animalId);
    }

    // 특정 동물 상세 조회
    @Transactional(readOnly = true)
    public ResponseAnimalDto getSingleAnimal(Long animalId) {
        Animal animal = animalRepository.findById(animalId).orElseThrow(() -> new AnimalException(ResponseCode.ANIMAL_NOT_FOUND));
        return ResponseAnimalDto.builder()
                .name(animal.getName())
                .species(animal.getSpecies())
                .photoUrl(animal.getPhotoUrl())
                .description(animal.getDescription())
                .mainLocation(animal.getMainLocation())
                .type(animal.getType())
                .link(animal.getLink())
                .build();
    }

    // 동물정보 전체 조회 (페이징)
    @Transactional(readOnly = true)
    public Page<ResponseAnimalDto> getAllAnimals(int page, int size) {
        Page<Animal> animals = animalRepository.findAll(PageRequest.of(page, size));
        return animals.map(animal -> ResponseAnimalDto.builder()
                .name(animal.getName())
                .species(animal.getSpecies())
                .photoUrl(animal.getPhotoUrl())
                .description(animal.getDescription())
                .mainLocation(animal.getMainLocation())
                .type(animal.getType())
                .link(animal.getLink())
                .build());
    }

    // 동물정보 종별로 조회 (페이징)
    @Transactional(readOnly = true)
    public Page<ResponseAnimalDto> getAnimalsBySpecies(String species, int page, int size) {
        Page<Animal> animals = animalRepository.findBySpecies(species, PageRequest.of(page, size));
        return animals.map(animal -> ResponseAnimalDto.builder()
                .name(animal.getName())
                .species(animal.getSpecies())
                .photoUrl(animal.getPhotoUrl())
                .description(animal.getDescription())
                .mainLocation(animal.getMainLocation())
                .type(animal.getType())
                .link(animal.getLink())
                .build());
    }

    // 동물정보 상태별로 조회 (페이징)
    @Transactional(readOnly = true)
    public Page<ResponseAnimalDto> getAnimalsByType(String type, int page, int size) {
        Page<Animal> animals = animalRepository.findByType(type, PageRequest.of(page, size));
        return animals.map(animal -> ResponseAnimalDto.builder()
                .name(animal.getName())
                .species(animal.getSpecies())
                .photoUrl(animal.getPhotoUrl())
                .description(animal.getDescription())
                .mainLocation(animal.getMainLocation())
                .type(animal.getType())
                .link(animal.getLink())
                .build());
    }

    // 동물정보 이름으로 조회 (페이징)
    @Transactional(readOnly = true)
    public Page<ResponseAnimalDto> getAnimalsContainingName(String name, int page, int size) {
        Page<Animal> animals = animalRepository.findByNameContaining(name, PageRequest.of(page, size));
        return animals.map(animal -> ResponseAnimalDto.builder()
                .name(animal.getName())
                .species(animal.getSpecies())
                .photoUrl(animal.getPhotoUrl())
                .description(animal.getDescription())
                .mainLocation(animal.getMainLocation())
                .type(animal.getType())
                .link(animal.getLink())
                .build());
    }
}
