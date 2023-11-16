package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Structure;
import kg.mega.employeedirectory.models.StructureType;
import kg.mega.employeedirectory.models.dtos.StructureDto;
import kg.mega.employeedirectory.repos.StructureRepo;
import kg.mega.employeedirectory.repos.StructureTypeRepo;
import kg.mega.employeedirectory.services.EditStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditStructureServiceImpl implements EditStructureService {
    private final StructureRepo structureRepo;
    private final StructureTypeRepo structureTypeRepo;

    @Override
    public ResponseEntity<?> saveStructure(StructureDto structureDto) {
        if (structureRepo.findStructureByName(structureDto.getStructureName()) == null) {
            Structure structure = new Structure();
            StructureType structureType = structureTypeRepo.findStructureTypeById(structureDto.getStructureTypeId());
            structure.setStructureType(structureType);
            structure.setParentStructure(structureRepo.findStructureById(structureDto.getParentStructure()));
            structure.setName(structureDto.getStructureName());
            structure.setActive(true);
            structureRepo.save(structure);
            return ResponseEntity.ok("Данные успешно сохранены");
        }
        return ResponseEntity.badRequest().body("Отдел с таким названием уже существует!");
    }

    @Override
    public ResponseEntity<?> changeStructureActivity(Long id) {
        Structure structure = structureRepo.findStructureById(id);
        if(structure == null){
            return ResponseEntity.badRequest().body("Указанный отдел не найден!");
        }
        if(structure.isActive()){
            structure.setActive(false);
            structureRepo.save(structure);
            return ResponseEntity.ok("Активность отдела успешна изменена.");
        }
        else {
            structure.setActive(true);
            structureRepo.save(structure);
            return ResponseEntity.ok("Активность отдела успешна изменена.");
        }
    }
}
