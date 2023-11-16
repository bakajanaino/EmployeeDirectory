package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.StructureDto;
import org.springframework.http.ResponseEntity;

public interface EditStructureService {
    ResponseEntity<?> saveStructure(StructureDto structureDto);
    ResponseEntity<?> changeStructureActivity(Long id);
}
