package com.aroma_Coffee_Hub.aroma_Backend.Controller;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.ApplyleaveDTO;
import com.aroma_Coffee_Hub.aroma_Backend.Model.ApprovalRequest;
import com.aroma_Coffee_Hub.aroma_Backend.Service.ApplyleaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( "*")
@RestController
@RequestMapping("/api/Applyleave")
public class Applyleavecontroller {

    private final ApplyleaveService applyleaveService;

    @Autowired
    public Applyleavecontroller(ApplyleaveService applyleaveService) {
        this.applyleaveService = applyleaveService;
    }

    @PostMapping
    public ResponseEntity<ApplyleaveDTO> applyForLeave(@RequestBody ApplyleaveDTO applyleaveDTO) {
        applyleaveDTO.setStatus("waiting for Approval"); // Set initial status when applying for leave
        ApplyleaveDTO savedApplyleave = applyleaveService.applyForLeave(applyleaveDTO);
        return new ResponseEntity<>(savedApplyleave, HttpStatus.CREATED);
    }

    @PutMapping("/approveLeave")
    public ResponseEntity<String> approveLeave(@RequestBody ApprovalRequest approvalRequest) {
        applyleaveService.approveLeave(approvalRequest.getId(), approvalRequest.getStatus());
        return ResponseEntity.ok("Leave status has been updated to " + approvalRequest.getStatus().toLowerCase() + ".");
    }


    @GetMapping
    public ResponseEntity<List<ApplyleaveDTO>> getAllLeaves() {
        List<ApplyleaveDTO> leaves = applyleaveService.getAllLeaves();
        return ResponseEntity.ok(leaves);
    }

    @GetMapping("/newLeavesCount")
    public ResponseEntity<Integer> getNewLeavesCount() {
        int newLeavesCount = applyleaveService.getNewLeavesCount();
        return ResponseEntity.ok(newLeavesCount);
    }

    @GetMapping("/totalLeavesCount")
    public ResponseEntity<Integer> getTotalLeavesCount() {
        int totalLeavesCount = applyleaveService.getTotalLeavesCount();
        return ResponseEntity.ok(totalLeavesCount);
    }
    @GetMapping("/totalRegisteredUsers")
    public ResponseEntity<Integer> getTotalRegisteredUsers() {
        int totalRegisteredUsers = applyleaveService.getTotalRegisteredUsers();
        return ResponseEntity.ok(totalRegisteredUsers);
    }


}
