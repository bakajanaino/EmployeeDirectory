package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.AdminSaveDto;
import kg.mega.employeedirectory.services.SaveAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class SaveAdminController {
    private final SaveAdminService saveAdminService;
    @PostMapping("save")
    public ResponseEntity<?> saveAdmin(@Valid @RequestBody AdminSaveDto adminSaveDto){
        return saveAdminService.saveAdmin(adminSaveDto);
    }
}
