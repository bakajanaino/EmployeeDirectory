package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.EmployeePosition;
import kg.mega.employeedirectory.models.Position;
import kg.mega.employeedirectory.models.Structure;
import kg.mega.employeedirectory.models.dtos.EmployeeEditDto;
import kg.mega.employeedirectory.models.enums.FamilyStatus;
import kg.mega.employeedirectory.models.enums.Status;
import kg.mega.employeedirectory.repos.EmployeePositionRepo;
import kg.mega.employeedirectory.repos.EmployeeRepo;
import kg.mega.employeedirectory.repos.PositionRepo;
import kg.mega.employeedirectory.repos.StructureRepo;
import kg.mega.employeedirectory.services.EditEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditEmployeeServiceImpl implements EditEmployeeService {
    private final EmployeeRepo employeeRepo;
    private final PositionRepo positionRepo;
    private final EmployeePositionRepo employeePositionRepo;
    private final StructureRepo structureRepo;
    @Override
    public ResponseEntity<?> editEmployee(EmployeeEditDto employeeEditDto) {
        Employee employee = employeeRepo.findEmployeeByFullNameIgnoreCase(employeeEditDto.getFullName());
        if(employee == null){
            return ResponseEntity.badRequest().body("Сотрудник не найден.");
        }

        if(employeeEditDto.getPhoneNumber() != null){
            employee.setPhoneNumber(employeeEditDto.getPhoneNumber());
        }
        if(employeeEditDto.getEmail() != null) {
            employee.setPhoneNumber(employeeEditDto.getPhoneNumber());
    }
        if(employeeEditDto.getStatus() != null) {
            try {
                employeeEditDto.setStatus(employeeEditDto.getStatus().toUpperCase());
                Status status = Status.valueOf(employeeEditDto.getStatus());
                employee.setStatus(status);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Статус указан неверно!");
            }
        }
        if(employeeEditDto.getFamilyStatus() != null){
            try {
                employeeEditDto.setFamilyStatus(employeeEditDto.getFamilyStatus().toUpperCase());
                FamilyStatus familyStatus = FamilyStatus.valueOf(employeeEditDto.getFamilyStatus());
                employee.setFamilyStatus(familyStatus);
            }catch (IllegalArgumentException e){
                return ResponseEntity.badRequest().body("Статус семейного положения указан неверно!");
            }
        }
        if (employeeEditDto.getPhotoUrl() != null){
            employee.setPhotoUrl(employeeEditDto.getPhotoUrl());
        }
        if(employeeEditDto.getPositionName() != null){
            Position position = positionRepo.findPositionByName(employeeEditDto.getPositionName());
            if(position == null){
                return ResponseEntity.badRequest().body("Указанная позиция не найдена");
            }
            EmployeePosition employeePosition = employeePositionRepo.findEmployeePositionByEmployee(employee);
            employeePosition.setPosition(position);
            employeePositionRepo.save(employeePosition);
        }
        if(employeeEditDto.getStructureName() != null){
            Structure structure = structureRepo.findStructureByName(employeeEditDto.getStructureName());
            if(structure == null){
                return ResponseEntity.badRequest().body("Указанный отдел не найден.");
            }
            EmployeePosition employeePosition = employeePositionRepo.findEmployeePositionByEmployee(employee);
            employeePosition.setStructure(structure);
            employeePositionRepo.save(employeePosition);
        }
        employeeRepo.save(employee);
        return ResponseEntity.ok("Данные успешно изменены.");
    }

    @Override
    public ResponseEntity<?> editEmployeeFullName(String name, String newName) {
        Employee employee = employeeRepo.findEmployeeByFullNameIgnoreCase(name);
        employee.setFullName(newName);
        employeeRepo.save(employee);
        return ResponseEntity.ok("Новое имя успешно сохранено!");
    }
}


