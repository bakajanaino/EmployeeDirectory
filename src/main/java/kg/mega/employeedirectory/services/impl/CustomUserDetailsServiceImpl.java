package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.User;
import kg.mega.employeedirectory.models.UserRole;
import kg.mega.employeedirectory.repos.UserRepo;
import kg.mega.employeedirectory.repos.UserRoleRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;

    public CustomUserDetailsServiceImpl(UserRepo userRepo, UserRoleRepo userRoleRepo) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findUserByUserName(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Пользователь '%s' не найден", username));
        }

        UserRole userRole = userRoleRepo.findUserRoleByUser(user.get());
        if (userRole == null) {
            throw new UsernameNotFoundException(String.format("Роль пользователя '%s' не найдена", username));
        }

        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.get().getPassword())
                .roles(userRole.getUserRole())
                .build();
    }
}

