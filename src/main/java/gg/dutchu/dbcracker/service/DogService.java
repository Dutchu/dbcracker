package gg.dutchu.dbcracker.service;

import gg.dutchu.dbcracker.domain.Dog;
import gg.dutchu.dbcracker.repository.DogRepository;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void save(Dog dog) {
        dogRepository.save(dog);
    }
}
