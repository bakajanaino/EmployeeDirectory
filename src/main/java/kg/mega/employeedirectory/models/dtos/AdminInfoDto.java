package kg.mega.employeedirectory.models.dtos;

import kg.mega.employeedirectory.models.Admin;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class AdminInfoDto {
    Long id;
    String username;
    String email;
    Long employeeId;
    String role;

    public AdminInfoDto(Admin admin){
        this.id=admin.getId();
        this.username=admin.getUsername();
        this.email=admin.getEmail();
        this.employeeId=admin.getEmployee().getId();
        this.role=admin.getRole().toString();
    }

}
