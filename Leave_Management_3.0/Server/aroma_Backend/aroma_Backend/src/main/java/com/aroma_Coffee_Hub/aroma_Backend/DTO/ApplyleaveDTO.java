package com.aroma_Coffee_Hub.aroma_Backend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplyleaveDTO {

    private Long id;
    private String leaveType;

    @JsonFormat(pattern="MM-dd-yyyy")
    private Date fromDate;

    @JsonFormat(pattern="MM-dd-yyyy")
    private Date toDate;

    @JsonFormat(pattern="MM-dd-yyyy")
    private Date postingDate;

    private String description;
    private String status = "waiting for Approval";
}
