package kg.mega.employeedirectory.services.impl;
import kg.mega.employeedirectory.models.Employee;
import kg.mega.employeedirectory.models.User;
import kg.mega.employeedirectory.models.UserRole;
import kg.mega.employeedirectory.models.dtos.RegistrationDto;
import kg.mega.employeedirectory.repos.EmployeeRepo;
import kg.mega.employeedirectory.repos.UserRepo;
import kg.mega.employeedirectory.repos.UserRoleRepo;
import kg.mega.employeedirectory.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder encoder;
    private final UserRoleRepo userRoleRepo;

    private final EmployeeRepo employeeRepo;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findUserByUserName(username);
    }

    @Override
    public User saveUser(RegistrationDto registrationDto) {
        User user = new User(registrationDto);
        UserRole userRole = new UserRole();
        Employee employee = employeeRepo.findEmployeeById(registrationDto.getEmployeeId());
        user.setPassword(encoder.encode(registrationDto.getPassword()));
        user.setUserName(registrationDto.getUsername());
        userRole.setUser(user);
        userRole.setUserRole("USER");
        user.setStartDate(LocalDate.now());
        user.setEmployee(employee);
        userRepo.save(user);
        userRoleRepo.save(userRole);
        return user;
    }
}


