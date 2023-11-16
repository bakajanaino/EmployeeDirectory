package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.StructureDto;
import kg.mega.employeedirectory.services.EditStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/structure/edit")
@RequiredArgsConstructor
public class StructureEditController {
    private final EditStructureService editStructureService;
    @PostMapping("/save")
    public ResponseEntity<?> saveStructure(@RequestBody StructureDto structureDto){
        return editStructureService.saveStructure(structureDto);
    }

    @PutMapping("/changeActivity")
    public ResponseEntity<?> changeActivity(@RequestParam Long id){
        return editStructureService.changeStructureActivity(id);
    }

}
