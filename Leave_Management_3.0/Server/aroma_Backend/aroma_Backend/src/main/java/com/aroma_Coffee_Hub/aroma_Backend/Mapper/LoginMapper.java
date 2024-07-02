package com.aroma_Coffee_Hub.aroma_Backend.Mapper;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.logindto;
import com.aroma_Coffee_Hub.aroma_Backend.entity.login;

public class LoginMapper {

    public static logindto loginToLoginDTO(login loginEntity) {
        logindto loginDTO = new logindto();
        loginDTO.setId(loginEntity.getId()); // Map id
        loginDTO.setEmail(loginEntity.getEmail()); // Map email
        loginDTO.setPassword(loginEntity.getPassword()); // Map password
        loginDTO.setCurrentPassword(loginEntity.getCurrentPassword()); // Map currentPassword
        // Add more mappings if needed
        return loginDTO;
    }

    public static login loginDTOToLogin(logindto loginDTO) {
        login loginEntity = new login(
                loginDTO.getId(), // Pass the ID if available
                loginDTO.getEmail(), // Map email
                loginDTO.getPassword(), // Map password
                loginDTO.getCurrentPassword() // Map currentPassword
        );
        return loginEntity;
    }
}
