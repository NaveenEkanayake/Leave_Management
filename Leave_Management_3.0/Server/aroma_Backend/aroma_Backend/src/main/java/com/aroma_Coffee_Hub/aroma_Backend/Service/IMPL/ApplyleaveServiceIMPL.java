package com.aroma_Coffee_Hub.aroma_Backend.Service.IMPL;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.ApplyleaveDTO;
import com.aroma_Coffee_Hub.aroma_Backend.Mapper.ApplyleaveMapper;
import com.aroma_Coffee_Hub.aroma_Backend.Repo.Applyreo;
import com.aroma_Coffee_Hub.aroma_Backend.Repo.loginrepo;
import com.aroma_Coffee_Hub.aroma_Backend.Service.ApplyleaveService;
import com.aroma_Coffee_Hub.aroma_Backend.entity.Applyleave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplyleaveServiceIMPL implements ApplyleaveService {

    private final Applyreo applyleaveRepository;
    private final loginrepo Loginrepo;
    @Autowired
    public ApplyleaveServiceIMPL(Applyreo applyleaveRepository, loginrepo loginrepo) {
        this.applyleaveRepository = applyleaveRepository;
       this.Loginrepo = loginrepo;
    }

    @Override
    public ApplyleaveDTO applyForLeave(ApplyleaveDTO applyleaveDTO) {
        Applyleave applyleave = ApplyleaveMapper.mapToApplyleave(applyleaveDTO);
        Applyleave savedApplyleave = applyleaveRepository.save(applyleave);
        incrementNewLeavesCount();
        return ApplyleaveMapper.mapToApplyleaveDTO(savedApplyleave);
    }


    @Override
    public List<ApplyleaveDTO> getAllLeaves() {
        return applyleaveRepository.findAll().stream()
                .map(ApplyleaveMapper::mapToApplyleaveDTO)
                .collect(Collectors.toList());
    }

    private void incrementNewLeavesCount() {
        int newLeavesCount = getNewLeavesCount();
        newLeavesCount++;
    }

    @Override
    public int getNewLeavesCount() {
        return (int) applyleaveRepository.countByStatus("waiting for Approval");
    }

    @Override
    public int getTotalLeavesCount() {
        return (int) applyleaveRepository.count();
    }

    @Override
    public void approveLeave(Long leaveId, String action, String description) {
        Optional<Applyleave> optionalLeave = applyleaveRepository.findById(leaveId);
        if (optionalLeave.isPresent()) {
            Applyleave leave = optionalLeave.get();
            leave.setStatus(action);
            leave.setDescription(description);
            applyleaveRepository.save(leave);
        } else {
            throw new IllegalArgumentException("Leave with ID " + leaveId + " not found.");
        }
    }

    @Override
    public void approveLeave(Long id, String action) {
        Optional<Applyleave> optionalLeave = applyleaveRepository.findById(id);
        if (optionalLeave.isPresent()) {
            Applyleave leave = optionalLeave.get();
            leave.setStatus(action);
            applyleaveRepository.save(leave);
        } else {
            throw new IllegalArgumentException("Leave with ID " + id + " not found.");
        }
    }

    @Override
    public int getTotalRegisteredUsers() {
        return Loginrepo.countloginByEmailContaining("employee");
    }


}

