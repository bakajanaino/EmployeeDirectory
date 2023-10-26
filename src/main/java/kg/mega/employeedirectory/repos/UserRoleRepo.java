package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.User;
import kg.mega.employeedirectory.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findUserRoleByUser(User user);

}
