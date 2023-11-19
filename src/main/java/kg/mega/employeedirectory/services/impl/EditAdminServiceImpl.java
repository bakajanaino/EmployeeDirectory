package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Admin;
import kg.mega.employeedirectory.models.dtos.AdminEditDto;
import kg.mega.employeedirectory.models.enums.Role;
import kg.mega.employeedirectory.repos.AdminRepo;
import kg.mega.employeedirectory.repos.EmployeeRepo;
import kg.mega.employeedirectory.services.EditAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditAdminServiceImpl implements EditAdminService {
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepo employeeRepo;
    @Override
    public ResponseEntity<?> editAdmin(AdminEditDto adminEditDto) {
        if (adminEditDto != null) {
            Admin admin = adminRepo.findAdminByUsername(adminEditDto.getUsername());
            if (adminEditDto.getPassword() != null && !adminEditDto.getPassword().equals(adminEditDto.getConfirmPassword())) {
                return ResponseEntity.badRequest().body("Пароли не совпадают!");
            }
            if (adminEditDto.getPassword() != null) {
                admin.setPassword(passwordEncoder.encode(adminEditDto.getPassword()));
                adminRepo.save(admin);
                return ResponseEntity.ok("Пароль успешно изменен!");
            }
            if (adminEditDto.getEmployeeId() != null) {
                admin.setEmployee(employeeRepo.findEmployeeById(adminEditDto.getEmployeeId()));
                adminRepo.save(admin);
                return ResponseEntity.ok("ID сотрудника успешно изменен!");
            }
            if (adminEditDto.getEmail() != null) {
                admin.setEmail(adminEditDto.getEmail());
                adminRepo.save(admin);
                return ResponseEntity.ok("Эл. почта успешно изменена!");
            }

        }
        return ResponseEntity.ok("Изменений не внесено.");
    }

    @Override
    public ResponseEntity<?> changeRole(String username) {
        Admin admin = adminRepo.findAdminByUsername(username);
        if(admin == null){
            return ResponseEntity.badRequest().body("Админ с таким логином не найден!");
        }
        if(admin.getRole().equals(Role.ADMIN)){
            admin.setRole(Role.DISABLED);
            adminRepo.save(admin);
            return ResponseEntity.ok("Роль админа изменена на DISABLED.");
        }
        else {
            admin.setRole(Role.ADMIN);
            adminRepo.save(admin);
            return ResponseEntity.ok("Роль админа изменена на ADMIN.");
        }
    }
}
