package kg.mega.employeedirectory.services;

import org.springframework.http.ResponseEntity;

public interface StructureTypeService {
    ResponseEntity<?> saveStructureType(String name);
}
