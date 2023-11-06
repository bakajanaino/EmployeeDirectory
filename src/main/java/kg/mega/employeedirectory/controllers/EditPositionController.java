package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.PositionDto;
import kg.mega.employeedirectory.services.EditPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/position/edit")
public class EditPositionController {
    private final EditPositionService editPositionService;

    @PostMapping("/save")
    public ResponseEntity<?> savePosition(@RequestBody PositionDto positionDto){
        return editPositionService.savePosition(positionDto);
    }

    @PutMapping("/changeActivity")
    public ResponseEntity<?> changeActivity(@RequestParam Long id){
       return editPositionService.changeActivity(id);
    }

}
