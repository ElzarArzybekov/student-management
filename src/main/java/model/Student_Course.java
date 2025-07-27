package model;

import java.util.Date;

public class Student_Course {
    private int student_id;
    private int course_id;
    private Date enrolment_Date;

    public Student_Course(int student_id, int course_id, Date enrolment_Date) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.enrolment_Date = enrolment_Date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Date getEnrolment_Date() {
        return enrolment_Date;
    }

    public void setEnrolment_Date(Date enrolment_Date) {
        this.enrolment_Date = enrolment_Date;
    }

    @Override
    public String toString() {
        return "Student_Course{" +
                "student_id=" + student_id +
                ", course_id=" + course_id +
                ", enrolment_Date=" + enrolment_Date +
                '}';
    }
}
