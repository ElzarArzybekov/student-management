package Repository;

import db.DataConnection;
import model.Course;
import model.Student;
import model.Student_Course;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    public boolean addNewCourse(Course course) {
        String sql = "INSERT INTO course(name, description, teacher_id, credits) VALUES(?, ?, ?, ?)";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,course.getName());
            stmt.setString(2,course.getDescription());
            stmt.setInt(3,course.getTeacherId());
            stmt.setInt(4,course.getCredits());
            return stmt.executeUpdate()>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addStudentToCourseById(int studentId, int courseId, LocalDate enrolmentDate) {
        String sql = "INSERT INTO student_course(student_id, course_id, enrolment_date) VALUES(?, ?, ?)";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, courseId);
            stmt.setInt(2, studentId);
            stmt.setDate(3, Date.valueOf(enrolmentDate));
            return stmt.executeUpdate()>0;
        }catch (Exception e)
            {
            e.printStackTrace();
            }
        return false;
    }
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Course course = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("teacher_Id"),
                        rs.getInt("credits")
                );
                courses.add(course);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return courses;
    }
    public List<Student_Course> getAllStudentsAtTheCourse() {
        List<Student_Course> student_courses = new ArrayList<>();
        String sql = "SELECT * FROM student_course";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Student_Course studentCourse = new Student_Course(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrolment_Date")
                );
                student_courses.add(studentCourse);
            }
        }catch (SQLException e)
            {
            e.printStackTrace();
            }
        return student_courses;
    }
    public boolean DeleteCourseById(int courseId) {
        String sql = "DELETE FROM course WHERE id = ?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, courseId);
            return stmt.executeUpdate()>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public List<Course> findTeacherCourses(int teacherId) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE teacher_id = ?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, teacherId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Course t = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("teacher_Id"),
                        rs.getInt("credits")
                );
                courses.add(t);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return courses;
    }
    public List<Student_Course> findStudentByCourseId(int courseId) {
        List<Student_Course> student_courses = new ArrayList<>();
        String sql = "SELECT * FROM student_course WHERE course_id = ?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Student_Course studentCourse = new Student_Course(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrolment_Date")
                );
                student_courses.add(studentCourse);
            }
        }catch (SQLException e)
            {
            e.printStackTrace();
            }
        return student_courses;
    }
    public List<Student_Course> myEnrolledCourses(int id) {
        List<Student_Course> student_courses = new ArrayList<>();
        String sql = "SELECT * FROM student_course WHERE student_id = ?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Student_Course sc = new Student_Course(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrolment_Date")
                );
                student_courses.add(sc);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return student_courses;
    }
}
