package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Admin findAdminByUsername(String username);
}
