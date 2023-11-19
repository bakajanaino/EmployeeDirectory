package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.dtos.EmployeeEditDto;
import kg.mega.employeedirectory.services.EditEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employee/edit")
public class EditEmployeeController {
    private final EditEmployeeService editEmployeeService;

    @PutMapping("/editEmployee")
    public ResponseEntity<?> editEmployee(@Valid @RequestBody EmployeeEditDto employeeEditDto){
        return editEmployeeService.editEmployee(employeeEditDto);
    }
    @PutMapping("/editName")
    public ResponseEntity<?> editEmployeeFullName(@RequestParam String name, @RequestParam String newName){
        return editEmployeeService.editEmployeeFullName(name, newName);
    }
}
