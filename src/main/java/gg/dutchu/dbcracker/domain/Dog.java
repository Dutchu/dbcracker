package gg.dutchu.dbcracker.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
//@Table(name = "DOG_TBL")
public class Dog {
    @Id
    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
            strategy = GenerationType.TABLE,
            generator = "dog_id_generator")
//    @SequenceGenerator(
//            name = "dog_sequence",
//            sequenceName = "dog_sequence",
//            allocationSize = 1
//    )
    @TableGenerator(
            name = "dog_id_generator",
            table = "id_gen",
            pkColumnName = "gen_name",
            valueColumnName = "gen_val",
            allocationSize = 1)
    private Long id;

    public Dog(String name, String breed, Date birthDate, Owner owner) {
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.owner = owner;
    }

    @Column(
            name = "dog_name",
            nullable = false,
            length = 30)
    private String name;

    private String breed;
    private Date birthDate;

    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(
            insertable = false)
    private LocalDateTime lastModifiedAt;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    /***
     * Do not map Bidirectional many-to-many relationship if only competition will have functionality to update the relationship
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(
            mappedBy = "dog",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<DogCompetitionScore> scores = new HashSet<>();

}
