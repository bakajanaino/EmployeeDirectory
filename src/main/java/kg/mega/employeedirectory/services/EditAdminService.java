package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.AdminEditDto;
import org.springframework.http.ResponseEntity;

public interface EditAdminService {
    ResponseEntity<?> editAdmin(AdminEditDto adminEditDto);
    ResponseEntity<?> changeRole(String username);
}
