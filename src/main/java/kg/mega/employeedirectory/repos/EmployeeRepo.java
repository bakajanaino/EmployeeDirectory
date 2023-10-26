package kg.mega.employeedirectory.repos;
import kg.mega.employeedirectory.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByFullNameContainingIgnoreCase(String employeeName);
    List<Employee> findEmployeeByEmailContainingIgnoreCase(String email);
    @Query(value = "SELECT e.* FROM employee e JOIN structure s ON e.structure_id = s.id WHERE LOWER(s.name) = LOWER(:name)", nativeQuery = true)
    List<Employee> findEmployeeByStructure(String name);
    List<Employee> findEmployeeByPhoneNumber(String phoneNumber);
    Employee findEmployeeById(Long id);
}