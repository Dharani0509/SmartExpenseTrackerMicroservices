package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("createAdmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.saveAdmin(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long adminId) {
        Admin admin = adminService.getAdminById(adminId);
        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
        Admin admin = adminService.getAdminByEmail(email);
        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }

//    @PutMapping("/{adminId}")
//    public ResponseEntity<Admin> updateAdmin(@PathVariable Long adminId, @RequestBody Admin admin) {
//        Admin updatedAdmin = adminService.updateAdmin(adminId, admin);
//        return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
//    }
    @PutMapping("/{adminId}")
    public ResponseEntity<String> updateAdmin(@PathVariable Long adminId, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(adminId, admin);

        if (updatedAdmin != null) {
            // Success message with the updated admin details
            String successMessage = "Admin with ID " + adminId + " has been updated successfully.";

            // Return the success message and updated admin in the response body
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);
        } else {
            // If the admin is not found, return an error message
            String errorMessage = "Admin with ID " + adminId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


//    @DeleteMapping("/{adminId}")
//    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) {
//        adminService.deleteAdmin(adminId);
//        String successMessage = "Admin with ID " + adminId + " has been deleted successfully.";
//        System.out.println("Admin with ID " + adminId + " has been deleted successfully.");
//       // return ResponseEntity.noContent().build();
//        return ResponseEntity.status(HttpStatus.OK).body(successMessage);
//    }
    @DeleteMapping("/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long adminId) {
        adminService.deleteAdmin(adminId);
        // Create the success message
        String successMessage = "Admin with ID " + adminId + " has been deleted successfully.";

        // Return 200 OK status with the success message in the response body
        return ResponseEntity.status(HttpStatus.OK).body(successMessage);
    }

}

