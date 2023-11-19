package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.AdminInfoDto;
import kg.mega.employeedirectory.services.SearchAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/search")
@RequiredArgsConstructor
public class SearchAdminController {
    private final SearchAdminService searchAdminService;

    @GetMapping("/findAll")
    public List<AdminInfoDto> findAll(){
        return searchAdminService.showAllAdmins();
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<?> findById(String username){
        return searchAdminService.searchAdminByName(username);
    }
}
