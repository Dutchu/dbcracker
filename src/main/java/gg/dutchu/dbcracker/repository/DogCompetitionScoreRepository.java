package gg.dutchu.dbcracker.repository;

import gg.dutchu.dbcracker.domain.DogCompetitionScore;
import gg.dutchu.dbcracker.domain.DogCompetitionScoreId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogCompetitionScoreRepository extends JpaRepository<DogCompetitionScore, DogCompetitionScoreId> {
}
