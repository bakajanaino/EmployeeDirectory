package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Admin;
import kg.mega.employeedirectory.models.dtos.AdminSaveDto;
import kg.mega.employeedirectory.models.enums.Role;
import kg.mega.employeedirectory.repos.AdminRepo;
import kg.mega.employeedirectory.repos.EmployeeRepo;
import kg.mega.employeedirectory.services.SaveAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveAdminServiceImpl implements SaveAdminService {
    private final EmployeeRepo employeeRepo;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<?> saveAdmin(AdminSaveDto adminSaveDto) {
        if(adminRepo.findAdminByUsername(adminSaveDto.getUsername()) != null){
            return ResponseEntity.badRequest().body("Админ с таким логином уже существует!");
        }
        if(adminSaveDto.getPassword().equals(adminSaveDto.getConfirmPassword())) {
            Admin admin = new Admin(adminSaveDto);
            admin.setPassword(passwordEncoder.encode(adminSaveDto.getPassword()));
            admin.setRole(Role.ADMIN);
            admin.setEmployee(employeeRepo.findEmployeeById(adminSaveDto.getEmployeeId()));
            adminRepo.save(admin);
            return ResponseEntity.ok("Админ успешно сохранен!");
        }
        return ResponseEntity.badRequest().body("Пароли не совпадают!");
    }
}
