package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StructureRepo extends JpaRepository<Structure, Long> {
    Structure findStructureByName(String structureName);
}
