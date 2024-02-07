package gdsc.cau.alert.animal.repository;

import gdsc.cau.alert.animal.domain.Animal;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @BatchSize(size = 50)
    Page<Animal> findByType(String type, PageRequest pageRequest);

    @BatchSize(size = 50)
    Page<Animal> findBySpecies(String species, PageRequest pageRequest);

    @BatchSize(size = 50)
    Page<Animal> findByNameContaining(String name, PageRequest pageRequest);
}
