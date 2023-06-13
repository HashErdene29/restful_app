package edu.miu.restful.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminInfo(){
        String result = "This is a request that only admin can access.";
        return result;
    }
}
