package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.dtos.EmployeeInfoDto;
import kg.mega.employeedirectory.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/findByStructure")
    public List<Employee>findByStructure(@RequestParam String name){
        return employeeService.findEmployeeByStructure(name);
    }
    @GetMapping("/findByEmail")
    public List<Employee> findByEmail(@RequestParam String email){
        return employeeService.findEmployeeByEmail(email);
    }
    @GetMapping("/findByStatus")
    public List<Employee> findByStatus(@RequestParam String status) {
        //TODO
        return null;
    }
    @GetMapping("/findByPosition")
    public List<Employee> findByPosition(@RequestParam String name){
        //TODO
        return null;
    }

    @GetMapping("/fullInfoByName")
    public List<EmployeeInfoDto> fullInfoByName(String fullName) throws Exception{
        return employeeService.getFullEmployeeInfoByName(fullName);
    }




}

