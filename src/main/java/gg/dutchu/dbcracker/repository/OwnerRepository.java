package gg.dutchu.dbcracker.repository;

import gg.dutchu.dbcracker.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
