package kg.mega.employeedirectory.models.dtos;

import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class EmployeeSaveDto {
    @NotBlank(message = "Имя не должно быть пустым!")
    String fullName;
    LocalDate employmentDate;
    @Pattern(regexp = "^\\+996.*", message = "Номер телефон должен начинаться с +996!")
    String phoneNumber;
    @Email(message = "Введите корректный адресс электронной почты!")
    String email;
    String photoUrl;
    String positionName;
    String structureName;
    String status;
    String familyStatus;
    String address;
    LocalDate dateOfBirth;
}
