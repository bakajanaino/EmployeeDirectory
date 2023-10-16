package kg.mega.employeedirectory.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @ManyToOne
    Positions positions;
    String fullName;
    LocalDate startDate;
    LocalDate endDate;
    @ManyToOne
    Structure structure;
    String phoneNumber;
    String email;
    String status;
    Double salary;
    String familyStatus;
    String photoUrl;
}
