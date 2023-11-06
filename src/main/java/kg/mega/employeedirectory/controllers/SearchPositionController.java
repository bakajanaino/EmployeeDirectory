package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.Position;
import kg.mega.employeedirectory.services.SearchPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/position/search")
@RestController
public class SearchPositionController {
    private final SearchPositionService searchPositionService;

    @GetMapping("/showAll")
    public List<Position> findAll(){
        return searchPositionService.findAllPositions();
    }

}
