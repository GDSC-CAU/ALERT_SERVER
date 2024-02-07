package gdsc.cau.alert.animal.controller;

import gdsc.cau.alert.animal.dto.CreateAnimalDto;
import gdsc.cau.alert.animal.dto.ResponseAnimalDto;
import gdsc.cau.alert.animal.dto.UpdateAnimalDto;
import gdsc.cau.alert.animal.service.AnimalService;
import gdsc.cau.alert.util.api.ApiResponse;
import gdsc.cau.alert.util.api.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/animal")
@RequiredArgsConstructor
@RestController
public class AnimalController {

    private final AnimalService animalService;

    // 동물정보 전체 조회 (페이징)
    @GetMapping("/all?page={page}&size={size}")
    public ApiResponse<Page<ResponseAnimalDto>> getAllAnimals(@PathVariable int page, @PathVariable int size) {
        return ApiResponse.success(animalService.getAllAnimals(page, size), ResponseCode.ANIMAL_READ_SUCCESS.getMessage());
    }

    // 동물정보 종별로 조회 (페이징)
    @GetMapping("/species/{species}?page={page}&size={size}")
    public ApiResponse<Page<ResponseAnimalDto>> getAnimalsBySpecies(@PathVariable String species, @PathVariable int page, @PathVariable int size) {
        return ApiResponse.success(animalService.getAnimalsBySpecies(species, page, size), ResponseCode.ANIMAL_READ_SUCCESS.getMessage());
    }

    // 동물정보 상태별로 조회 (페이징)
    @GetMapping("/type/{type}?page={page}&size={size}")
    public ApiResponse<Page<ResponseAnimalDto>> getAnimalsByType(@PathVariable String type, @PathVariable int page, @PathVariable int size) {
        return ApiResponse.success(animalService.getAnimalsByType(type, page, size), ResponseCode.ANIMAL_READ_SUCCESS.getMessage());
    }

    // 동물정보 이름으로 조회 (페이징)
    @GetMapping("/name/{name}?page={page}&size={size}")
    public ApiResponse<Page<ResponseAnimalDto>> getAnimalsContainingName(@PathVariable String name, @PathVariable int page, @PathVariable int size) {
        return ApiResponse.success(animalService.getAnimalsContainingName(name, page, size), ResponseCode.ANIMAL_READ_SUCCESS.getMessage());
    }

    // 특정 동물 상세 조회
    @GetMapping("/{animalId}")
    public ApiResponse<ResponseAnimalDto> getSingleAnimal(@PathVariable Long animalId) {
        return ApiResponse.success(animalService.getSingleAnimal(animalId), ResponseCode.ANIMAL_READ_SUCCESS.getMessage());
    }

    // 동물 신규 생성
    @PostMapping
    public ApiResponse<Long> createAnimal(@RequestBody CreateAnimalDto createAnimalDto) {
        return ApiResponse.success(animalService.createAnimal(createAnimalDto), ResponseCode.ANIMAL_CREATE_SUCCESS.getMessage());
    }

    // 동물정보 수정
    @PutMapping
    public ApiResponse<Void> updateAnimal(@RequestBody UpdateAnimalDto updateAnimalDto) {
        animalService.updateAnimal(updateAnimalDto);
        return ApiResponse.success(null, ResponseCode.ANIMAL_UPDATE_SUCCESS.getMessage());
    }

    // 동물정보 삭제
    @DeleteMapping("/{animalId}")
    public ApiResponse<Void> deleteAnimal(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);
        return ApiResponse.success(null, ResponseCode.ANIMAL_DELETE_SUCCESS.getMessage());
    }
}
