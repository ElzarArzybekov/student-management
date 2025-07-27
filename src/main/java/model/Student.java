package model;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private String email;
    private int groupId;
    private int courseId;
    private LocalDate enrollmentDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", groupId=" + groupId +
                ", courseId=" + courseId +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }

    public Student(int id, String fullName, int age, String email, int groupId, LocalDate enrollmentDate, int courseId) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.groupId = groupId;
        this.enrollmentDate = enrollmentDate;
        this.courseId = courseId;
    }
}
