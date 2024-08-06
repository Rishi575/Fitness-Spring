package com.example.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.model.Admin;
import com.example.gym.repo.AdminRepo;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepo adminRepo;

    public List<Admin> findAllAdmin(){
        return adminRepo.findAll();
    }

    public Admin addAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    public void deleteAdmin(Long aid){
        adminRepo.deleteById(aid);
    }
    
}
