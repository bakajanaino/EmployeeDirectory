package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.StructureDto;
import kg.mega.employeedirectory.services.StructureEditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/structure/edit")
@RequiredArgsConstructor
public class StructureEditController {
    private final StructureEditService structureEditService;
    @PostMapping("/save")
    public ResponseEntity<?> saveStructure(@RequestBody StructureDto structureDto){
        return structureEditService.saveStructure(structureDto);
    }

    @PutMapping("/changeActivity")
    public ResponseEntity<?> changeActivity(@RequestParam Long id){
        return structureEditService.changeStructureActivity(id);
    }

}
