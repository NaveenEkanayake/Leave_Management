package com.aroma_Coffee_Hub.aroma_Backend.Service;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.logindto;

public interface loginservice {
    boolean authenticateUser(String email, String password);
    logindto getUserDetails(Long id);
    logindto createUser(logindto userDetails);
    boolean updatePassword(String email, String currentPassword, String newPassword, String confirmPassword);;
}
