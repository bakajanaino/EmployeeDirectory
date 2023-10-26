package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.dtos.AuthRequestDto;
import kg.mega.employeedirectory.models.dtos.RegistrationDto;
import kg.mega.employeedirectory.services.AuthService;
import kg.mega.employeedirectory.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsServiceImpl userDetailsService;


    @Override
    public ResponseEntity<?> createNewUser(RegistrationDto registrationDto) {
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Пароли не совпадают!");
        }
        if (userService.findByUsername(registrationDto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(String.format("Пользователь с логином '%s' уже существует!", registrationDto.getUsername()));
        }

        userService.saveUser(registrationDto);
        return ResponseEntity.ok("Успешная регистрация!");
    }


}
