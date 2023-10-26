package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.User;
import kg.mega.employeedirectory.models.UserRole;
import kg.mega.employeedirectory.repos.UserRepo;
import kg.mega.employeedirectory.repos.UserRoleRepo;
import kg.mega.employeedirectory.services.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;
    private final UserRepo userRepo;

}
