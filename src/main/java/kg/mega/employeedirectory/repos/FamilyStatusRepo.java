package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.FamilyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FamilyStatusRepo extends JpaRepository<FamilyStatus, Long> {
   List <FamilyStatus> findFamilyStatusByEmployeeFullNameContainingIgnoreCase(String fullName);
}
