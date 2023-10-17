package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployeeByName(String employee);
    Employee saveEmployee(Employee employee);
    List<Employee> findEmployeeByEmail(String email);

    List<Employee> findEmployeeByStructure(String name);

    Employee findEmployeeByPhoneNumber(String phoneNumber);
}
