package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Structure;
import kg.mega.employeedirectory.models.dtos.StructureDto;
import kg.mega.employeedirectory.repos.StructureRepo;
import kg.mega.employeedirectory.services.SearchStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class SearchStructureServiceImpl implements SearchStructureService {

    private final StructureRepo structureRepo;
    @Override
    public ResponseEntity<?> findStructureByStructureName(String name) {
        name = name.toUpperCase();
        Structure structure = structureRepo.findStructureByName(name);
        if(structure == null){
            return ResponseEntity.badRequest().body("Отдел не найден.");
        }
        List<Structure> allStructures = structureRepo.findAll();

        return ResponseEntity.ok(Stream.concat(
                        Stream.of(new StructureDto(structure)),
                        allStructures.stream()
                                .filter(s -> s.getParentStructure().getId() < structure.getParentStructure().getId())
                                .map(StructureDto::new)
                )
                .collect(Collectors.toList()));
    }

    @Override
    public List<StructureDto> findAllStructures() {
        List<Structure> allStructures = structureRepo.findAll();

        return Stream.concat(
                Stream.of(),
                allStructures.stream()
                        .map(StructureDto::new)
        )
                .collect(Collectors.toList());
    }
}
