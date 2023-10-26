package kg.mega.employeedirectory.models;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class    UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User user;
    String userRole;
    LocalDate startDate;
    LocalDate endDate;


}
