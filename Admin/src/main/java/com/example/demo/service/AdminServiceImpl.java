package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long adminId) {
        return adminRepository.findById(adminId).orElse(null);  // Return null if not found
    }

   

    @Override
    public Admin updateAdmin(Long adminId, Admin admin) {
        if (adminRepository.existsById(adminId)) {
            admin.setAdminId(adminId);
            return adminRepository.save(admin);
        }
        return null; // or throw exception if needed
    }

    @Override
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }

	@Override
	public Admin getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(email);
	}


}


