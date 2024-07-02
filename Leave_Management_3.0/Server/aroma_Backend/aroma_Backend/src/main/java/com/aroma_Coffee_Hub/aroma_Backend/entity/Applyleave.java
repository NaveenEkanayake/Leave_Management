package com.aroma_Coffee_Hub.aroma_Backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Apply_leave")
public class Applyleave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "leaveType")
    private String leaveType;

    @JsonFormat(pattern="MM-dd-yyyy") // Apply format to fromDate
    @Temporal(TemporalType.DATE)
    @Column(name = "from_date")
    private Date fromDate;

    @JsonFormat(pattern="MM-dd-yyyy") // Apply format to toDate
    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    private Date toDate;

    @JsonFormat(pattern="MM-dd-yyyy") // Apply format to postingDate
    @Temporal(TemporalType.DATE)
    @Column(name = "posting_date")
    private Date postingDate;

    @Column(name = "description")
    private String description;

    @Column(name = "Status")
    private String status = "waiting for Approval";

    @PrePersist
    protected void onCreate() {
        postingDate = new Date();
    }
}
