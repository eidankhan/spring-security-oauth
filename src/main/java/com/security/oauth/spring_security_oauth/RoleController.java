package com.security.oauth.spring_security_oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the Training Planner Application!";
    }

    @GetMapping("/home")
    public String home() {
        return "This is the home page for authenticated users.";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard - restricted to users with ADMIN role.";
    }

    @GetMapping("/manager/dashboard")
    public String managerDashboard() {
        return "Manager Dashboard - restricted to users with MANAGER role.";
    }

    @GetMapping("/employee/dashboard")
    public String employeeDashboard() {
        return "Employee Dashboard - restricted to users with EMPLOYEE role.";
    }
}
