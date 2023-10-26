package kg.mega.employeedirectory.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeSaveDto {
    String fullName;
    LocalDate employmentDate;
    String phoneNumber;
    String email;
    String photoUrl;
    String positionName;
    String structureName;
    String status;
    String familyStatus;

}
