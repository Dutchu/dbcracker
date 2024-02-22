package gg.dutchu.dbcracker.repository;

import gg.dutchu.dbcracker.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
