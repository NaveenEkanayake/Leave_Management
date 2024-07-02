// ApplyleaveService.java
package com.aroma_Coffee_Hub.aroma_Backend.Service;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.ApplyleaveDTO;

import java.util.List;

public interface ApplyleaveService {
    ApplyleaveDTO applyForLeave(ApplyleaveDTO applyleaveDTO);

    List<ApplyleaveDTO> getAllLeaves();

    int getNewLeavesCount();

    int getTotalLeavesCount();

    void approveLeave(Long leaveId, String action, String description);

    void approveLeave(Long id, String action);

    int getTotalRegisteredUsers();


}
