package gg.dutchu.dbcracker.service;

import gg.dutchu.dbcracker.domain.DogCompetitionScore;
import gg.dutchu.dbcracker.repository.DogCompetitionScoreRepository;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    DogCompetitionScoreRepository dogCompetitionScoreRepository;

public ScoreService(DogCompetitionScoreRepository dogCompetitionScoreRepository) {
        this.dogCompetitionScoreRepository = dogCompetitionScoreRepository;
    }

    public void removeScore(DogCompetitionScore score) {
    }
}
