package kg.mega.employeedirectory.controllers;

import kg.mega.employeedirectory.models.dtos.AuthRequestDto;
import kg.mega.employeedirectory.models.dtos.RegistrationDto;
import kg.mega.employeedirectory.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationDto registrationDto){
        return authService.createNewUser(registrationDto);
    }

    @GetMapping("/getToken")
    public ResponseEntity<?> getToken(@RequestParam String username, @RequestParam String password){
        AuthRequestDto authRequestDto = new AuthRequestDto(username, password);
        return authService.auth(authRequestDto);
    }

}