package kg.mega.employeedirectory.models;

import kg.mega.employeedirectory.models.dtos.AdminSaveDto;
import kg.mega.employeedirectory.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_admin")
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    @ManyToOne
    Employee employee;
    @Enumerated(EnumType.STRING)
    Role role;

    public Admin(AdminSaveDto adminSaveDto){
        this.username=adminSaveDto.getUsername();
        this.password=adminSaveDto.getPassword();
        this.email=adminSaveDto.getEmail();
    }
}
