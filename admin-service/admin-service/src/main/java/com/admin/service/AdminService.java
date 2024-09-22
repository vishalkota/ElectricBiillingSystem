package com.admin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.admin.entity.Admin;
import com.admin.repo.AdminRepository;
 
 
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
 
 
    public Admin getAdmin(Long id) {
        return adminRepository.findById(id).orElseThrow();
    }
 
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
 
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
 
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
