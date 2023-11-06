package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.EmployeePosition;
import kg.mega.employeedirectory.models.Position;
import kg.mega.employeedirectory.models.Structure;
import kg.mega.employeedirectory.models.dtos.EmployeeSaveDto;
import kg.mega.employeedirectory.models.enums.FamilyStatus;
import kg.mega.employeedirectory.models.enums.Status;
import kg.mega.employeedirectory.repos.*;
import kg.mega.employeedirectory.services.SaveEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SaveEmployeeServiceImpl implements SaveEmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeePositionRepo employeePositionRepo;
    private final PositionRepo positionRepo;
    private final StructureRepo structureRepo;



    @Override
    public ResponseEntity<?> saveEmployee(EmployeeSaveDto employeeSaveDto) {
        if (employeeSaveDto.getFullName().length() >= 2 && employeeSaveDto.getFullName().length() <= 50) {
            if (employeeSaveDto.getPhoneNumber().startsWith("+996")) {
                if (employeeSaveDto.getEmail().contains("@") && employeeSaveDto.getEmail().contains(".")) {
                    employeeSaveDto.setStatus(employeeSaveDto.getStatus().toUpperCase());
                    employeeSaveDto.setFamilyStatus(employeeSaveDto.getFamilyStatus().toUpperCase());
                    try {
                        Status status = Status.valueOf(employeeSaveDto.getStatus());
                        FamilyStatus familyStatus = FamilyStatus.valueOf(employeeSaveDto.getFamilyStatus());
                        Employee employee = new Employee();
                        EmployeePosition employeePosition = new EmployeePosition();
                        employee.setStatus(status);
                        employee.setFamilyStatus(familyStatus);
                        employee.setFullName(employeeSaveDto.getFullName());
                        employee.setEmail(employeeSaveDto.getEmail());
                        employee.setEmploymentDate(LocalDate.now());
                        employee.setPhoneNumber(employeeSaveDto.getPhoneNumber());
                        employeePosition.setEmployee(employee);
                        Position position = positionRepo.findPositionByName(employeeSaveDto.getPositionName());
                        employeePosition.setPosition(position);
                        Structure structure = structureRepo.findStructureByName(employeeSaveDto.getStructureName());
                        employeePosition.setStructure(structure);
                        employeeRepo.save(employee);
                        employeePositionRepo.save(employeePosition);
                        return ResponseEntity.ok("Сотрудник успешно сохранен!");
                    } catch (IllegalArgumentException e) {
                        return ResponseEntity.badRequest().body("Указанный статус не существует.");
                    }
                }
            }
        }
        return ResponseEntity.badRequest().body("Данные указаны неверно!");
    }
}
