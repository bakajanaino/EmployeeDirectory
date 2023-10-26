package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchEmployeeService {

    ResponseEntity<?> saveEmployee(Employee employee) throws Exception;
    List<EmployeeInfoDto> getFullEmployeeInfoByName(String fullName) throws Exception;
    List<EmployeeInfoDto> findEmployeeByEmail(String email) throws Exception;
    List<EmployeeInfoDto> findEmployeeByPhoneNumber(String phoneNumber) throws Exception;
    List<EmployeeInfoDto> findEmployeesByStructureNameIgnoreCase(String structureName) throws Exception;
    List<EmployeeInfoDto> findEmployeesByPositionNameIgnoreCase(String positionName) throws Exception;

}
