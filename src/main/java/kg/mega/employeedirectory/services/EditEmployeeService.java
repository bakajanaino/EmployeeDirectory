package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.dtos.EmployeeEditDto;
import org.springframework.http.ResponseEntity;

public interface EditEmployeeService {
    ResponseEntity<?> editEmployee(EmployeeEditDto employeeEditDto);

    ResponseEntity<?> editEmployeeFullName(String name, String newName);
}
