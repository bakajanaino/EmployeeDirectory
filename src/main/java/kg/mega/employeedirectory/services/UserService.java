package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.dtos.RegistrationDto;
import kg.mega.employeedirectory.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User saveUser(RegistrationDto registrationDto);
}

