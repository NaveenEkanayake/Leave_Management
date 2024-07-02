package com.aroma_Coffee_Hub.aroma_Backend.Service.IMPL;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.logindto;
import com.aroma_Coffee_Hub.aroma_Backend.Mapper.LoginMapper;
import com.aroma_Coffee_Hub.aroma_Backend.Repo.loginrepo;
import com.aroma_Coffee_Hub.aroma_Backend.Service.loginservice;
import com.aroma_Coffee_Hub.aroma_Backend.entity.login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class loginServiceimpl implements loginservice {

    private loginrepo loginRepo;
    private final Logger logger = LoggerFactory.getLogger(loginServiceimpl.class);


    @Autowired
    public loginServiceimpl(loginrepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    @Override
    public boolean updatePassword(String email, String currentPassword, String newPassword, String confirmPassword) {
        // Validate inputs
        if (email == null || currentPassword == null || newPassword == null || confirmPassword == null ||
                newPassword.isEmpty() || confirmPassword.isEmpty()) {
            return false; // Invalid inputs
        }

        // Retrieve the user by email
        Optional<login> optionalUser = Optional.ofNullable(loginRepo.findByEmail(email));
        if (optionalUser.isPresent()) {
            login user = optionalUser.get();

            // Verify if the current password matches the stored password
            if (!currentPassword.equals(user.getPassword())) {
                return false; // Current password doesn't match
            }

            // Check if the new password and confirmation password match
            if (!newPassword.equals(confirmPassword)) {
                return false; // New password and confirmation password don't match
            }

            // Update the password with the new password
            user.setPassword(newPassword);

            // Save the updated user to the database
            loginRepo.save(user);

            return true; // Password updated successfully
        }
        return false; // User not found
    }
    @Override
    public boolean authenticateUser(String email, String password) {
        // Retrieve the user by email
        Optional<login> optionalUser = Optional.ofNullable(loginRepo.findByEmail(email));
        return optionalUser.isPresent() && password.equals(optionalUser.get().getPassword());
    }

    @Override
    public logindto getUserDetails(Long id) {
        Optional<login> loginOptional = loginRepo.findById(id);
        if (loginOptional.isPresent()) {
            login user = loginOptional.get();
            return LoginMapper.loginToLoginDTO(user);
        } else {
            return null;
        }
    }

    @Override
    public logindto createUser(logindto userDetails) {
        login newUser = LoginMapper.loginDTOToLogin(userDetails);
        login savedUser = loginRepo.save(newUser);
        return LoginMapper.loginToLoginDTO(savedUser);
    }
}
