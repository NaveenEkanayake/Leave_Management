package com.aroma_Coffee_Hub.aroma_Backend.Mapper;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.ApplyleaveDTO;
import com.aroma_Coffee_Hub.aroma_Backend.entity.Applyleave;

public class ApplyleaveMapper {

    public static ApplyleaveDTO mapToApplyleaveDTO(Applyleave applyleave) {
        if (applyleave == null) {
            return null;
        }
        ApplyleaveDTO applyleaveDTO = new ApplyleaveDTO();
        applyleaveDTO.setId(applyleave.getId());
        applyleaveDTO.setLeaveType(applyleave.getLeaveType());
        applyleaveDTO.setFromDate(applyleave.getFromDate());
        applyleaveDTO.setToDate(applyleave.getToDate());
        applyleaveDTO.setDescription(applyleave.getDescription());
        applyleaveDTO.setPostingDate(applyleave.getPostingDate());
        applyleaveDTO.setStatus(applyleave.getStatus()); // Set Status
        return applyleaveDTO;
    }

    public static Applyleave mapToApplyleave(ApplyleaveDTO applyleaveDTO) {
        if (applyleaveDTO == null) {
            return null;
        }
        Applyleave applyleave = new Applyleave();
        applyleave.setId(applyleaveDTO.getId());
        applyleave.setLeaveType(applyleaveDTO.getLeaveType());
        applyleave.setFromDate(applyleaveDTO.getFromDate());
        applyleave.setToDate(applyleaveDTO.getToDate());
        applyleave.setDescription(applyleaveDTO.getDescription());
        applyleave.setStatus(applyleaveDTO.getStatus());
        return applyleave;
    }
}