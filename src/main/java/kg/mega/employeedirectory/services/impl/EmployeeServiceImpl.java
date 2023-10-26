package kg.mega.employeedirectory.services.impl;
import kg.mega.employeedirectory.models.*;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;
import kg.mega.employeedirectory.repos.*;
import kg.mega.employeedirectory.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeePositionRepo employeePositionRepo;
    private final FamilyStatusRepo familyStatusRepo;
    private final SalaryRepo salaryRepo;
    private final EmployeeStatusRepo employeeStatusRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, EmployeePositionRepo employeePositionRepo, FamilyStatusRepo familyStatusRepo, SalaryRepo salaryRepo, EmployeeStatusRepo employeeStatusRepo) {
        this.employeeRepo = employeeRepo;
        this.employeePositionRepo = employeePositionRepo;
        this.familyStatusRepo = familyStatusRepo;
        this.salaryRepo = salaryRepo;
        this.employeeStatusRepo = employeeStatusRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getFullName().length() >= 2 && employee.getFullName().length() <= 50) {
            if (employee.getPhoneNumber().startsWith("+996")) {
                if (employee.getEmail().contains("@") && employee.getEmail().contains(".")) {
                    return employeeRepo.save(employee);
                }
            }
        }
        return null;
    }

    @Override
    public List<Employee> findEmployeeByEmail(String email) {
        return employeeRepo.findEmployeeByEmailContainingIgnoreCase(email);
    }

    @Override
    public List<Employee> findEmployeeByStructure(String name) {
        return employeeRepo.findEmployeeByStructure(name);
    }


    @Override
    public List<EmployeeInfoDto> getFullEmployeeInfoByName(String fullName) throws Exception {
        List<Employee> employees = employeeRepo.findEmployeeByFullNameContainingIgnoreCase(fullName);
        List<EmployeeInfoDto> employeeInfoDtos = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeePosition employeePosition = employeePositionRepo.
                    findEmployeePositionByEmployeeFullNameContainingIgnoreCase(employee.getFullName())
                    .stream().findFirst().orElse(null);
            EmployeeStatus employeeStatus = employeeStatusRepo.
                    findEmployeeStatusByEmployeeFullNameContainingIgnoreCase(employee.getFullName())
                    .stream().findFirst().orElse(null);
            Salary salary = salaryRepo.
                    findSalaryByEmployeeFullNameContainingIgnoreCase(employee.getFullName())
                    .stream().findFirst().orElse(null);
            FamilyStatus familyStatus = familyStatusRepo.
                    findFamilyStatusByEmployeeFullNameContainingIgnoreCase(employee.getFullName())
                    .stream().findFirst().orElse(null);

            if (employeePosition != null && employeeStatus != null && salary != null && familyStatus != null) {
                EmployeeInfoDto employeeInfoDto = new EmployeeInfoDto(employee, employeePosition,
                        employeeStatus, salary, familyStatus, employeePosition.getStructure());
                employeeInfoDtos.add(employeeInfoDto);
            }
        }

        if (!employeeInfoDtos.isEmpty()) {
            return employeeInfoDtos;
        } else {
            throw new Exception("Сотрудники не найдены.");
        }
    }
}






