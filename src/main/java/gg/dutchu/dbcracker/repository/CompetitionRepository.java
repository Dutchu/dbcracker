package gg.dutchu.dbcracker.repository;

import gg.dutchu.dbcracker.domain.Competition;
import gg.dutchu.dbcracker.model.CompetitionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    @Transactional
    @Query("SELECT c FROM Competition c JOIN FETCH c.scores s JOIN FETCH s.dog WHERE c.id = :id")
    CompetitionProjection findCompetitionWithDogCompetitionScore(@Param("id") Long id);

}
