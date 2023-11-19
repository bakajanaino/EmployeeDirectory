package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.AdminEditDto;
import kg.mega.employeedirectory.services.EditAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin/edit")
public class EditAdminController {
    private final EditAdminService editAdminService;

    @PutMapping("changeRole")
    public ResponseEntity<?> changeRole(@RequestParam String username){
        return editAdminService.changeRole(username);
    }
    @PutMapping("editAdmin")
    public ResponseEntity<?> editAdmin(@Valid @RequestBody AdminEditDto adminEditDto){
        return editAdminService.editAdmin(adminEditDto);
    }

}
