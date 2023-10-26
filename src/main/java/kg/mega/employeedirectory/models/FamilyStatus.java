package kg.mega.employeedirectory.models;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FamilyStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String familyStatus;
    LocalDate startDate;
    LocalDate endDate;
    @ManyToOne
    Employee employee;
}
