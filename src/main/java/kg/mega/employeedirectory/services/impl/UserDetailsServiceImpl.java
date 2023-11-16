package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Admin;
import kg.mega.employeedirectory.repos.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findAdminByUsername(username);
        if(admin == null){
            throw new UsernameNotFoundException("Админ с таким логином не найден.");
        }
        return new User(
                admin.getUsername(),
                admin.getPassword(),
                admin.getRole().getAuthorities()
        );
    }
}
