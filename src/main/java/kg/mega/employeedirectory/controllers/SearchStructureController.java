package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.StructureDto;
import kg.mega.employeedirectory.services.SearchStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/structure/search")
@RequiredArgsConstructor
public class SearchStructureController {
    private final SearchStructureService searchStructureService;

    @GetMapping("/findAll")
    public List<StructureDto> findAll(){
        return searchStructureService.findAllStructures();
    }


    @GetMapping("/findByName")
    public ResponseEntity<?> findStructureByName(@RequestParam String structureName){
        return searchStructureService.findStructureByStructureName(structureName);
    }
}
