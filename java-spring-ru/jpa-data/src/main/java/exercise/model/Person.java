package exercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

// BEGIN
@Entity
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;
}
// END
