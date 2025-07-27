package model;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private int enrolledAt;
    private String grade;

    public Enrollment(int id, int studentId, int courseId, int enrolledAt, String grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrolledAt = enrolledAt;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(int enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrolledAt=" + enrolledAt +
                ", grade='" + grade + '\'' +
                '}';
    }
}
