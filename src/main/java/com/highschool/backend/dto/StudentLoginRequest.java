package com.highschool.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class StudentLoginRequest {
    @NotBlank(message = "Student ID is required")

    private String studentId;

    @NotBlank(message = "Mobile number is required")

    @Pattern(

            regexp = "^[6-9]\\d{9}$",

            message = "Enter a valid 10-digit mobile number"

    )

    private String mobileNumber;

    public StudentLoginRequest() {

    }

    public String getStudentId() {

        return studentId;

    }

    public void setStudentId(String studentId) {

        this.studentId = studentId;

    }

    public String getMobileNumber() {

        return mobileNumber;

    }

    public void setMobileNumber(String mobileNumber) {

        this.mobileNumber = mobileNumber;

    }
}
