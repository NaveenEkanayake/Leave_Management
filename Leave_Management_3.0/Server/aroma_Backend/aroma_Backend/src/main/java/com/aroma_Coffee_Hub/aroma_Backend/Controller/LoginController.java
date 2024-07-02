package com.aroma_Coffee_Hub.aroma_Backend.Controller;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.logindto;
import com.aroma_Coffee_Hub.aroma_Backend.Service.loginservice;
import com.aroma_Coffee_Hub.aroma_Backend.entity.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/login")
public class LoginController {


    private final loginservice loginService;

    @Autowired
    public LoginController(loginservice loginService) {
        this.loginService = loginService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<logindto> getUserDetails(@PathVariable("id") Long id) {
        logindto userDetails = loginService.getUserDetails(id);
        return ResponseEntity.ok(userDetails);
    }


    @PostMapping("/authentication")
    public ResponseEntity<?> login(@RequestBody login Login) {
        String email = Login.getEmail().toLowerCase(); // Convert email to lowercase
        String password = Login.getPassword();

        boolean isAuthenticated = loginService.authenticateUser(email, password);

        // Create a response message object using a HashMap
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("message", isAuthenticated ? "Login successful" : "Invalid credentials");

        // Return the response with appropriate status
        if (isAuthenticated) {
            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMessage);
        }
    }


    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> passwordUpdateRequest) {
        String email = passwordUpdateRequest.get("email");
        String currentPassword = passwordUpdateRequest.get("currentPassword");
        String newPassword = passwordUpdateRequest.get("newPassword");
        String confirmPassword = passwordUpdateRequest.get("confirmPassword");

        // Validate the request parameters
        if (email == null || currentPassword == null || newPassword == null || confirmPassword == null) {
            return ResponseEntity.badRequest().body("Missing required parameters");
        }

        // Check if the new password and confirm password match
        if (!newPassword.equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("New password and confirm password do not match");
        }

        // Call the service method to update the password and check if it was successful
        boolean passwordUpdated = loginService.updatePassword(email, currentPassword, newPassword, confirmPassword);

        if (passwordUpdated) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update password");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<logindto> registerUser(@RequestBody logindto userDetails) {
        logindto newUserDetails = loginService.createUser(userDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUserDetails);
    }


}
