package kg.mega.employeedirectory.services.impl;
import kg.mega.employeedirectory.models.*;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;
import kg.mega.employeedirectory.models.enums.FamilyStatus;
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
    public ResponseEntity<?> saveEmployee(Employee employee) throws Exception {
        if (employee.getFullName().length() >= 2 && employee.getFullName().length() <= 50) {
            if (employee.getPhoneNumber().startsWith("+996")) {
                if (employee.getEmail().contains("@") && employee.getEmail().contains(".")) {
                    return ResponseEntity.ok(employeeRepo.save(employee));
                }
                return ResponseEntity.badRequest().body("Данные указаны неверно");
            }
        }
        return null;
    }


    @Override
    public List<EmployeeInfoDto> findEmployeeByEmail(String email) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeeByEmailContainingIgnoreCase(email);
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();

        for (Employee employee : employees) {
            getFullInfo(employeeInfoDtos, employee);
        }

        if (employeeInfoDtos.isEmpty()) {
            throw new Exception("Сотрудники не найдены.");
        }

        return employeeInfoDtos;
    }

    @Override
    public List<EmployeeInfoDto> findEmployeeByPhoneNumber(String phoneNumber) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeeByPhoneNumberContaining(phoneNumber);
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();
        for(Employee employee : employees){
            getFullInfo(employeeInfoDtos, employee);
        }
        if (employeeInfoDtos.isEmpty()) {
            throw new Exception("Сотрудники не найдены.");
        }

        return employeeInfoDtos;
    }

    @Override
    public List<EmployeeInfoDto> findEmployeesByStructureNameIgnoreCase(String structureName) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeesByStructureNameIgnoreCase(structureName);
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();
        for(Employee employee : employees){
            getFullInfo(employeeInfoDtos, employee);
        }
        if(employeeInfoDtos.isEmpty()){
            throw new Exception("Сотрудники не найдены");
        }
        return employeeInfoDtos;
    }

    @Override
    public List<EmployeeInfoDto> findEmployeesByPositionNameIgnoreCase(String positionName) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeesByPositionNameIgnoreCase(positionName);
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();
        for (Employee employee: employees){
            getFullInfo(employeeInfoDtos, employee);
        }
        if(employeeInfoDtos.isEmpty()){
            throw new Exception("Сотрудники не найдены");
        }
        return employeeInfoDtos;
    }

    private void getFullInfo(List<EmployeeInfoDto> employeeInfoDtos, Employee employee) {
        EmployeePosition employeePosition = employeePositionRepo.
                findEmployeePositionByEmployeeFullNameContainingIgnoreCase(employee.getFullName())
                .stream().findFirst().orElse(null);


        if (employeePosition != null) {
            EmployeeInfoDto employeeInfoDto = new EmployeeInfoDto(employee, employeePosition,
                    employeePosition.getStructure());
            employeeInfoDtos.add(employeeInfoDto);
        }
    }

    @Override
    public List<EmployeeInfoDto> getFullEmployeeInfoByName(String fullName) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeeByFullNameContainingIgnoreCase(fullName);
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();

        for (Employee employee : employees) {
            getFullInfo(employeeInfoDtos, employee);
        }

        if (!employeeInfoDtos.isEmpty()) {
            return employeeInfoDtos;
        } else {
            throw new Exception("Сотрудники не найдены.");
        }
    }
}






