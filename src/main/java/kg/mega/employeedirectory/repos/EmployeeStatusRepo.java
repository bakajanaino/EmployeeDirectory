package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeStatusRepo extends JpaRepository<EmployeeStatus, Long> {
   List<EmployeeStatus> findEmployeeStatusByEmployeeFullNameContainingIgnoreCase(String fullName);
}
