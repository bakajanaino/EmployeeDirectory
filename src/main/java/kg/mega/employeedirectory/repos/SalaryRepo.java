package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {
   List <Salary> findSalaryByEmployeeFullNameContainingIgnoreCase(String fullName);
}
