package kg.mega.employeedirectory.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

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
    @ManyToMany(mappedBy = "employee_id")
    Employee employee;
}
