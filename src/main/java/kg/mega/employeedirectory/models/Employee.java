package kg.mega.employeedirectory.models;

import kg.mega.employeedirectory.models.enums.FamilyStatus;
import kg.mega.employeedirectory.models.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fullName;
    LocalDate employmentDate;
    LocalDate dismissalDate;
    LocalDate startDate;
    LocalDate endDate;
    String phoneNumber;
    String email;
    String photoUrl;
    @Enumerated(EnumType.STRING)
    Status status;
    @Enumerated(EnumType.STRING)
    FamilyStatus familyStatus;


}
