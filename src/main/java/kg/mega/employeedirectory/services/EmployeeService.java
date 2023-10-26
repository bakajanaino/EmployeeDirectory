package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> findEmployeeByEmail(String email);
    List<Employee> findEmployeeByStructure(String name);
    List<EmployeeInfoDto> getFullEmployeeInfoByName(String fullName) throws Exception;


}
