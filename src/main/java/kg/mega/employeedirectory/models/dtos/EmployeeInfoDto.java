package kg.mega.employeedirectory.models.dtos;

import kg.mega.employeedirectory.models.*;
import kg.mega.employeedirectory.models.enums.FamilyStatus;
import kg.mega.employeedirectory.models.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeInfoDto {
    Long id;
    String fullName;
    String position;
    String structure;
    String phoneNumber;
    String email;
    Status status;
    FamilyStatus familyStatus;
    String photoUrl;
    LocalDate hireDate;
    LocalDate dismissalDate;
    String address;
    LocalDate dateOfBirth;


    public EmployeeInfoDto(Employee employee, EmployeePosition position, Structure structure, FamilyStatus familyStatus, Status status) {
        this.id=employee.getId();
        this.fullName=employee.getFullName();
        this.position=position.getPosition().getName();
        this.structure=structure.getName();
        this.phoneNumber=employee.getPhoneNumber();
        this.email=employee.getEmail();
        this.photoUrl=employee.getPhotoUrl();
        this.hireDate=employee.getEmploymentDate();
        this.dismissalDate=employee.getDismissalDate();
        this.status=status;
        this.familyStatus=familyStatus;
        this.address=employee.getAddress();
        this.dateOfBirth=employee.getDateOfBirth();
    }
}
