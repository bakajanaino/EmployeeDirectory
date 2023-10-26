package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.EmployeeSaveDto;
import org.springframework.http.ResponseEntity;

public interface SaveEmployeeService {
    ResponseEntity<?> saveEmployee(EmployeeSaveDto employeeSaveDto);
}
