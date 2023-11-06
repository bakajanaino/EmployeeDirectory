package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;
import kg.mega.employeedirectory.models.enums.Status;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchEmployeeService {

    ResponseEntity<?> getFullEmployeeInfoByName(String fullName) throws Exception;
    ResponseEntity<?> findEmployeeByEmail(String email) throws Exception;
    ResponseEntity<?> findEmployeeByPhoneNumber(String phoneNumber) throws Exception;
    ResponseEntity<?> findEmployeesByStructureNameIgnoreCase(String structureName) throws Exception;
    ResponseEntity<?> findEmployeesByPositionNameIgnoreCase(String positionName) throws Exception;
    ResponseEntity<?> findEmployeeByStatus(String stringStatus);
}
