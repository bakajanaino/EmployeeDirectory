package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.StructureDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchStructureService {
    ResponseEntity<?> findStructureByStructureName(String name);
    List<StructureDto> findAllStructures();

}
