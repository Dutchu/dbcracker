package gg.dutchu.dbcracker.model;

import java.util.Set;

//TODO: Change this to a records
public interface CompetitionProjection {
    Long getId();
    String getName();
    String getLocation();
    Set<DogScore> getScores();

    interface DogScore {
        Dog getDog();
        int getScore();
        int getRank();

        interface Dog {
            String getName();
        }
    }
}
