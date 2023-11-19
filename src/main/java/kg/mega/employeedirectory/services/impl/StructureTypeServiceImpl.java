package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.StructureType;
import kg.mega.employeedirectory.repos.StructureTypeRepo;
import kg.mega.employeedirectory.services.StructureTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StructureTypeServiceImpl implements StructureTypeService {
    private final StructureTypeRepo structureTypeRepo;
    @Override
    public ResponseEntity<?> saveStructureType(String name) {
        StructureType structureType = new StructureType();
        structureType.setActive(true);
        structureType.setName(name);
        structureTypeRepo.save(structureType);
        return ResponseEntity.ok("Тип отдела успешно сохранен.");
    }
}
