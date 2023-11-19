package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Admin;
import kg.mega.employeedirectory.models.dtos.AdminInfoDto;
import kg.mega.employeedirectory.repos.AdminRepo;
import kg.mega.employeedirectory.repos.EmployeeRepo;
import kg.mega.employeedirectory.services.SearchAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchAdminServiceImpl implements SearchAdminService {
    private final AdminRepo adminRepo;
    private final EmployeeRepo employeeRepo;
    @Override
    public ResponseEntity<?> searchAdminByName(String username) {
        Admin admin = adminRepo.findAdminByUsername(username);
        if(admin != null){
            AdminInfoDto adminInfoDto = new AdminInfoDto();
            adminInfoDto.setRole(admin.getRole().toString());
            adminInfoDto.setEmail(admin.getEmail());
            adminInfoDto.setUsername(username);
            adminInfoDto.setId(admin.getId());
            if(employeeRepo.findEmployeeById(admin.getEmployee().getId()) != null){
                 adminInfoDto.setEmployeeId(admin.getEmployee().getId());
             }
            return ResponseEntity.ok(adminInfoDto);
        }
        return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<AdminInfoDto> showAllAdmins() {
        List<AdminInfoDto> adminInfoDtos = new ArrayList<>();
        adminInfoDtos = adminRepo.findAll().stream().map(this::convertToDto)
                .collect(Collectors.toList());
        return adminInfoDtos;
    }


    private AdminInfoDto convertToDto(Admin admin){
        return new AdminInfoDto(admin);
    }
}
