package kg.mega.employeedirectory.services.impl;
import kg.mega.employeedirectory.models.*;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;
import kg.mega.employeedirectory.models.enums.FamilyStatus;
import kg.mega.employeedirectory.models.enums.Status;
import kg.mega.employeedirectory.repos.*;
import kg.mega.employeedirectory.services.SearchEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchEmployeeServiceImpl implements SearchEmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeePositionRepo employeePositionRepo;



    public SearchEmployeeServiceImpl(EmployeeRepo employeeRepo, EmployeePositionRepo employeePositionRepo) {
        this.employeeRepo = employeeRepo;
        this.employeePositionRepo = employeePositionRepo;
    }

    @Override
    public ResponseEntity<?> findEmployeeByEmail(String email) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeeByEmailContainingIgnoreCase(email);
        return getAllEmployees(employees);
    }

    private ResponseEntity<?> getAllEmployees(List<Employee> employees) {
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();

        for (Employee employee : employees) {
            getFullInfo(employeeInfoDtos, employee);
        }

        if (employeeInfoDtos.isEmpty()) {
            return ResponseEntity.badRequest().body("Сотрудники не найдены.");
        }

        return ResponseEntity.ok(employeeInfoDtos);
    }

    @Override
    public ResponseEntity<?> findEmployeeByPhoneNumber(String phoneNumber) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeeByPhoneNumberContaining(phoneNumber);

        return getAllEmployees(employees);
    }
    @Override
    public ResponseEntity<?> findEmployeesByStructureNameIgnoreCase(String structureName) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeesByStructureNameIgnoreCase(structureName);
        return getAllEmployees(employees);
    }
    @Override
    public ResponseEntity<?> findEmployeesByPositionNameIgnoreCase(String positionName) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeesByPositionNameIgnoreCase(positionName);
        return getAllEmployees(employees);
    }
    @Override
    public ResponseEntity<?> findEmployeeByStatus(String stringStatus) {
        stringStatus = stringStatus.toUpperCase();
        List <Employee> employees = employeeRepo.findEmployeeByStatus(Status.valueOf(stringStatus));
        return getAllEmployees(employees);

    }
    private void getFullInfo(List<EmployeeInfoDto> employeeInfoDtos, Employee employee) {
        EmployeePosition employeePosition = employeePositionRepo.
                findEmployeePositionByEmployeeFullNameContainingIgnoreCase(employee.getFullName())
                .stream().findFirst().orElse(null);
        Status status = employee.getStatus();
        FamilyStatus familyStatus = employee.getFamilyStatus();
        if (employeePosition != null) {
            EmployeeInfoDto employeeInfoDto = new EmployeeInfoDto(employee, employeePosition,
                    employeePosition.getStructure(), familyStatus, status);
            employeeInfoDtos.add(employeeInfoDto);
        }
    }
    @Override
    public ResponseEntity<?> getFullEmployeeInfoByName(String fullName) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeeByFullNameContainingIgnoreCase(fullName);
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();
        for (Employee employee : employees) {
            getFullInfo(employeeInfoDtos, employee);
        }
        if (!employeeInfoDtos.isEmpty()) {
            return ResponseEntity.ok(employeeInfoDtos);
        } else {
            return ResponseEntity.badRequest().body("Сотрудники не найдены.");
        }
    }
}






