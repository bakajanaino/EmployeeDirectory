package kg.mega.employeedirectory.repos;

import kg.mega.employeedirectory.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String username);
    User findByUserName(String username);


}
