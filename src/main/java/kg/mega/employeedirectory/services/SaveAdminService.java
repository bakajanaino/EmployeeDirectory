package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.AdminSaveDto;
import org.springframework.http.ResponseEntity;

public interface SaveAdminService {


    ResponseEntity<?> saveAdmin(AdminSaveDto adminSaveDto);
}
