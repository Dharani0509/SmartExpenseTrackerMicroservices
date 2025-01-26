package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Admin;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Admin getAdminById(Long adminId);

    Admin getAdminByEmail(String email);

    Admin updateAdmin(Long adminId, Admin admin);

    void deleteAdmin(Long adminId);
}
