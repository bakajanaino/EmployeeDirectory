package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;
import kg.mega.employeedirectory.services.SearchEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee/search")
public class SearchEmployeeController {
    private final SearchEmployeeService searchEmployeeService;
    public SearchEmployeeController(SearchEmployeeService searchEmployeeService) {
        this.searchEmployeeService = searchEmployeeService;
    }
    @GetMapping("/findByPhoneNumber")
    public List<EmployeeInfoDto> findByPhone(@RequestParam String phoneNumber)throws Exception{
        return searchEmployeeService.findEmployeeByPhoneNumber(phoneNumber);
    }
    @GetMapping("/findByEmail")
    public List<EmployeeInfoDto> findByEmail(@RequestParam String email) throws Exception {
        return searchEmployeeService.findEmployeeByEmail(email);

    }
    @GetMapping("/findByStatus")
    public List<Employee> findByStatus(@RequestParam String status) {
        //TODO
        return null;
    }
    @GetMapping("/findByPosition")
    public List<EmployeeInfoDto> findByPosition(@RequestParam String positionName) throws Exception {
        return searchEmployeeService.findEmployeesByPositionNameIgnoreCase(positionName);
    }

    @GetMapping("/findByStructure")
    public List<EmployeeInfoDto> findByStructure(@RequestParam String structureName) throws Exception {
        return searchEmployeeService.findEmployeesByStructureNameIgnoreCase(structureName);
    }

    @GetMapping("/fullInfoByName")
    public List<EmployeeInfoDto> fullInfoByName(String fullName) throws Exception{
        return searchEmployeeService.getFullEmployeeInfoByName(fullName);
    }




}

