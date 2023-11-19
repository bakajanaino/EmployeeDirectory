package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.services.StructureTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/structureType")
@RequiredArgsConstructor
public class StructureTypeController {
    private final StructureTypeService structureTypeService;
    @PostMapping("/save")
    public ResponseEntity<?> saveStructureType(String name){
        return structureTypeService.saveStructureType(name);
    }
}
