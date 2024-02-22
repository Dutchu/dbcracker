package gg.dutchu.dbcracker.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "owner")
    private List<Dog> dogs;

}
