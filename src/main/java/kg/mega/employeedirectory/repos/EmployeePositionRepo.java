package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeePositionRepo extends JpaRepository<EmployeePosition, Long> {
   List <EmployeePosition> findEmployeePositionByEmployeeFullNameContainingIgnoreCase(String fullName);

   EmployeePosition findEmployeePositionByEmployee(Employee employee);

}
