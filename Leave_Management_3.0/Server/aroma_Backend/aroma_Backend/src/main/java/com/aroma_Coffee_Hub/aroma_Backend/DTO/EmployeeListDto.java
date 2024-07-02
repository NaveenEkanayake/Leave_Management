package com.aroma_Coffee_Hub.aroma_Backend.DTO;

public class EmployeeListDto {
    private int totalCount;

    public EmployeeListDto(int totalCount) {
        this.totalCount = totalCount;
    }

    public EmployeeListDto() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "EmployeeListDto{" +
                "totalCount=" + totalCount +
                '}';
    }
}
