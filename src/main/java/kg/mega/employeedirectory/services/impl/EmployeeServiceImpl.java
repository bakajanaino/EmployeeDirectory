package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.repo.EmployeeRepo;
import kg.mega.employeedirectory.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getFullName().length() >= 2 && employee.getFullName().length() <= 50) {
            if (employee.getPhoneNumber().startsWith("+996")) {
                if (employee.getEmail().contains("@")&&employee.getEmail().contains(".")){
                return employeeRepo.save(employee);
                 }
             }
        }
        return null;
    }
    @Override
    public List<Employee> findEmployeeByName(String employee) {
        return employeeRepo.findEmployeeByFullNameContainingIgnoreCase(employee);
    }
    @Override
    public List<Employee> findEmployeeByEmail(String email){
        return employeeRepo.findEmployeeByEmailContainingIgnoreCase(email);
    }
    public List<Employee> findEmployeeByStatus(String status){
        return employeeRepo.findEmployeeByStatusIgnoreCase(status);
    }

    public List<Employee> findEmployeeByStructure(String name){
        return employeeRepo.findEmployeeByStructure(name);
    }
    @Override
    public List<Employee> findEmployeeByPositions (String name){
         return employeeRepo.findEmployeeByPositions(name);
    }

}



