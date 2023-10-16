package kg.mega.employeedirectory.repo;

import feign.Param;
import kg.mega.employeedirectory.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByFullNameContainingIgnoreCase(String employeeName);

    List<Employee> findEmployeeByEmailContainingIgnoreCase(String email);

    List<Employee> findEmployeeByStatusIgnoreCase(String status);

    @Query(value = "SELECT e.* FROM employee e JOIN structure s ON e.structure_id = s.id WHERE LOWER(s.name) = LOWER(:name)", nativeQuery = true)
    List<Employee> findEmployeeByStructure(String name);
    @Query(value = "SELECT e.*FROM employee e JOIN positions p ON e.positions_id = p.id WHERE LOWER(p.name) = LOWER(:name)", nativeQuery = true)
    List<Employee> findEmployeeByPositions (String name);
}