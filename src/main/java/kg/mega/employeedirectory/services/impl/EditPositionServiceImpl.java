package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Position;
import kg.mega.employeedirectory.models.dtos.PositionDto;
import kg.mega.employeedirectory.repos.PositionRepo;
import kg.mega.employeedirectory.repos.StructureRepo;
import kg.mega.employeedirectory.services.EditPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditPositionServiceImpl implements EditPositionService {
    private final PositionRepo positionRepo;
    private final StructureRepo structureRepo;
    @Override
    public ResponseEntity<?> savePosition(PositionDto positionDto) {
        Position position = new Position();
        if (positionRepo.findPositionByName(positionDto.getName()) != null) {
            return ResponseEntity.badRequest().body("Позиция с таким названием уже существует!");
        }
            if (structureRepo.findStructureById(positionDto.getStructureId()) == null) {
                return ResponseEntity.badRequest().body("Отдел не найден.");
            }
            position.setName(positionDto.getName());
            position.setStructure(structureRepo.findStructureById(positionDto.getStructureId()));
            position.setParentPosition(positionRepo.findPositionById(positionDto.getParentPosition()));
            position.setActive(true);
            positionRepo.save(position);
            return ResponseEntity.ok("Новая позция успешно сохранена!");
        }

    @Override
    public ResponseEntity<?> changeActivity(Long id) {
        Position position = positionRepo.findPositionById(id);
        if(position != null){
            if(position.isActive()){
                position.setActive(false);
                positionRepo.save(position);
                return ResponseEntity.ok("Статус активности позиции успешно изменен!");
            }
            position.setActive(true);
            positionRepo.save(position);
            return ResponseEntity.ok("Статус активности позиции успешно изменен!");
        }
        return ResponseEntity.badRequest().body("Позиция по указанному id не найдена.");
    }
}
