package gg.dutchu.dbcracker;

import gg.dutchu.dbcracker.domain.*;
import gg.dutchu.dbcracker.repository.CompetitionRepository;
import gg.dutchu.dbcracker.repository.DogCompetitionScoreRepository;
import gg.dutchu.dbcracker.repository.DogRepository;
import gg.dutchu.dbcracker.repository.OwnerRepository;
import gg.dutchu.dbcracker.service.CompetitionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbcrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbcrackerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CompetitionService competitionService, DogRepository dogRepository, OwnerRepository ownerRepository, DogCompetitionScoreRepository dogCompetitionScoreRepository, CompetitionRepository competitionRepository) {
        return args -> {

            var johnDoe = Owner.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .build();
            ownerRepository.save(johnDoe);

            var competition = new Competition("Best in Show", "New York");
            competitionRepository.save(competition);

            var dog = new Dog("Burek", "Labrador", new java.util.Date(), johnDoe);
            var dog2 =  new Dog("Burek2", "Labrador", new java.util.Date(), johnDoe);
            dogRepository.save(dog);
            dogRepository.save(dog2);

            competition.addDog(dog);
            competition.addDog(dog2);
            competitionRepository.save(competition);

            //TODO: Hibernate still does not removes relation record from DOG_COMPETITION_SCORE even tho object is removed from collection on both sides of bidirectional relation.
            competitionService.removeDogFromCompetition(competition, dog);
            competitionRepository.save(competition);

            competitionService.getCompetition(competition.getId());

        };
    }
}