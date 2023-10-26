package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.User;
import kg.mega.employeedirectory.models.UserRole;

public interface UserRoleService {
    UserRole findByUserRole(User user);
}
