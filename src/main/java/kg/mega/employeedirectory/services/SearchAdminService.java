package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.AdminInfoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchAdminService {
    ResponseEntity<?> searchAdminByName(String username);
    List<AdminInfoDto> showAllAdmins();
}
