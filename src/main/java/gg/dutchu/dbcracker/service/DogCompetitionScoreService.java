package gg.dutchu.dbcracker.service;

import gg.dutchu.dbcracker.domain.Competition;
import gg.dutchu.dbcracker.domain.Dog;
import gg.dutchu.dbcracker.domain.DogCompetitionScore;
import gg.dutchu.dbcracker.domain.DogCompetitionScoreId;
import gg.dutchu.dbcracker.repository.DogCompetitionScoreRepository;
import org.springframework.stereotype.Service;

@Service
public class DogCompetitionScoreService {
    private final DogCompetitionScoreRepository dogCompetitionScoreRepository;

    public DogCompetitionScoreService(DogCompetitionScoreRepository dogCompetitionScoreRepository) {
        this.dogCompetitionScoreRepository = dogCompetitionScoreRepository;
    }

    public void deleteScore(Dog dog, Competition competition) {
        DogCompetitionScoreId id = new DogCompetitionScoreId(dog.getId(), competition.getId());
        dogCompetitionScoreRepository.deleteById(id);
    }
}
