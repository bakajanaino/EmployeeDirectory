package kg.mega.employeedirectory.models;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class StructureType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    boolean isActive;
}
