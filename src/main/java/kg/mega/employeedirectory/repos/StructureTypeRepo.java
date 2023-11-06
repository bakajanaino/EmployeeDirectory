package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.StructureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureTypeRepo extends JpaRepository<StructureType, Long> {
    StructureType findStructureTypeById(Long id);
}
