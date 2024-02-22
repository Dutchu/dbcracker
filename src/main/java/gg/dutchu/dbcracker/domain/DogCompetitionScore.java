package gg.dutchu.dbcracker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class DogCompetitionScore {

    @EmbeddedId
    private DogCompetitionScoreId id;

    @ManyToOne
    @MapsId("dogId")
    private Dog dog;

    @ManyToOne
    @MapsId("competitionId")
    private Competition competition;

    private int score;

    private int rank;

    public DogCompetitionScore(Competition competition, Dog dog) {
        this.dog = dog;
        this.competition = competition;
    }

    private String note;
}
