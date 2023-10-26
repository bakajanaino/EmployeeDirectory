package kg.mega.employeedirectory.models.dtos;

import kg.mega.employeedirectory.models.*;
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
    String status;
    String familyStatus;
    String photoUrl;
    LocalDate hireDate;
    LocalDate dismissalDate;


    public EmployeeInfoDto(Employee employee, EmployeePosition position, Structure structure) {
        this.id=employee.getId();
        this.fullName=employee.getFullName();
        this.position=position.getPosition().getName();
        this.structure=structure.getName();
        this.phoneNumber=employee.getPhoneNumber();
        this.email=employee.getEmail();
        this.photoUrl=employee.getPhotoUrl();
        this.hireDate=employee.getEmploymentDate();
        this.dismissalDate=employee.getDismissalDate();
    }
    public EmployeeInfoDto(){}

}
