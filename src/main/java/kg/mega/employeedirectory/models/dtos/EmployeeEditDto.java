package kg.mega.employeedirectory.models.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Data
public class EmployeeEditDto {
    @NotBlank(message = "Имя не должно быть пустым!")
    @Max(30)
    String fullName;
    LocalDate employmentDate;
    @Pattern(regexp = "^\\\\+996\\\\d{9,}$", message = "Номер телефон должен начинаться с +996!")
    String phoneNumber;
    @Email
    String email;
    String photoUrl;
    String positionName;
    String structureName;
    String status;
    String familyStatus;
    String address;
    LocalDate dateOfBirth;
}
