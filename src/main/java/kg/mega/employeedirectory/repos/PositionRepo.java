package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends JpaRepository<Position, Long> {
}
