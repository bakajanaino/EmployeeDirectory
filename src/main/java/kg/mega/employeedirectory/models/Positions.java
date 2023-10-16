package kg.mega.employeedirectory.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.cdi.Eager;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    Structure structure;
    @ManyToOne
    @JoinColumn(name = "parent_position_id")
    Positions parenPosition;

}
