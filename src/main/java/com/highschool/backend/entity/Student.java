package com.highschool.backend.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@Entity
@Table(name = "students")
@JsonPropertyOrder(
        {     "id",
                "studentId",
                "name",
                "mobileNumber",
                "classNumber"}
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id", unique = true, nullable = false)
    private String studentId;
    @Column(nullable = false)
    private String name;
    @Column(name = "mobile_number", unique = true, nullable = false)
    private String mobileNumber;
    @Column(name = "class_number", nullable = false)
    private Integer classNumber;
    public Student() {
    }
    public Student(String studentId, String name, String mobileNumber, Integer classNumber) {
        this.studentId = studentId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.classNumber = classNumber;
    }
    public Long getId() {
        return id;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public Integer getClassNumber() {
        return classNumber;
    }
    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }
}
