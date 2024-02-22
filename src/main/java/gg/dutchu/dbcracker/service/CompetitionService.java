package gg.dutchu.dbcracker.service;

import gg.dutchu.dbcracker.domain.Competition;
import gg.dutchu.dbcracker.domain.Dog;
import gg.dutchu.dbcracker.domain.DogCompetitionScore;
import gg.dutchu.dbcracker.repository.CompetitionRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final DogService dogService;
    private final DogCompetitionScoreService scoreService;

    public CompetitionService(CompetitionRepository competitionRepository, DogService dogService, DogCompetitionScoreService scoreService) {
        this.competitionRepository = competitionRepository;
        this.scoreService = scoreService;
        this.dogService = dogService;
    }


    public void removeDogFromCompetition(Competition competition, Dog dog) {
        competition.removeDog(dog);
        scoreService.deleteScore(dog, competition);
        competitionRepository.save(competition);
    }
    public void  getCompetition(Long id) {

        competitionRepository.findCompetitionWithDogCompetitionScore(id).getScores().forEach(
                score -> {
                    System.out.println(score.getDog().getName());
                }
        );
    }
}