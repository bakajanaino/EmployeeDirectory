package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.PositionDto;
import org.springframework.http.ResponseEntity;

public interface EditPositionService {
    ResponseEntity<?> savePosition(PositionDto positionDto);
    ResponseEntity<?> changeActivity(Long id);
}
