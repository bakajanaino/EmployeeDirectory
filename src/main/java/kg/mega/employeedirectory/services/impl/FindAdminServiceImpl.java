package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Admin;
import kg.mega.employeedirectory.repos.AdminRepo;
import kg.mega.employeedirectory.services.FindAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FindAdminServiceImpl implements FindAdminService {
    private final AdminRepo adminRepo;
    @Override
    public List<Admin> findAllAdmins() {
        return adminRepo.findAll();
    }
}
