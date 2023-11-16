package kg.mega.employeedirectory.models.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class AdminEditDto {
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+{}\\[\\]:;<>,.?~\\-=/]{3,20}$", message = "Логин не соответствует требованиям!")
    String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&_])[A-Za-z\\d@$!%*?&_]{8,}$", message = "Пароль не соответствует требованиям!")
    String password;
    String confirmPassword;
    @Email(message = "Неправильно указана электронная почта!")
    String email;
    Long employeeId;
}
