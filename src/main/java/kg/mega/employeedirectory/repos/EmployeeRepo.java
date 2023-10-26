package kg.mega.employeedirectory.repos;
import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByFullNameContainingIgnoreCase(String employeeName);

    @Query(value = "SELECT e.* FROM employee e JOIN structure s ON e.structure_id = s.id WHERE LOWER(s.name) = LOWER(:name)", nativeQuery = true)
    List<Employee> findEmployeeByStructure(String name);
    List<Employee> findEmployeeByPhoneNumberContaining(String phoneNumber);
    @Query(value = "SELECT * FROM Employee WHERE LOWER(email) LIKE LOWER(concat('%', :email, '%'))", nativeQuery = true)
    List<Employee>findEmployeeByEmailContainingIgnoreCase(String email);
    Employee findEmployeeById(Long id);

    @Query(value = "SELECT * FROM employee e " +
            "JOIN employee_position ep ON e.id = ep.employee_id " +
            "JOIN structure s ON ep.structure_id = s.id " +
            "WHERE LOWER(s.name) = LOWER(:structureName)", nativeQuery = true)
    List<Employee> findEmployeesByStructureNameIgnoreCase(String structureName);


    @Query(value = "SELECT e.* FROM employee e " +
            "JOIN employee_position ep ON e.id = ep.employee_id " +
            "JOIN position p ON ep.position_id = p.id " +
            "WHERE LOWER(p.name) = LOWER(:positionName)", nativeQuery = true)
    List<Employee> findEmployeesByPositionNameIgnoreCase(String positionName);
}

