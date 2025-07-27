package Repository;

import db.DataConnection;
import model.Student;
import model.Student_Course;
import model.Teacher;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public Student findByFullName(String fullName) {
        String sql = "SELECT * FROM student WHERE full_name=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, fullName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Student(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getInt("group_id"),
                        rs.getDate("enrollmentDate").toLocalDate(),
                        rs.getInt("courseId")
                );
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean save(Student student) {
        String sql = "INSERT INTO student (full_name, email, age, group_id, enrollmentDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, student.getFullName());
            stmt.setString(2, student.getEmail());
            stmt.setInt(3, student.getAge());
            stmt.setInt(4, student.getGroupId());
            stmt.setDate(5, Date.valueOf(student.getEnrollmentDate()));
            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: "+rowsInserted);
            return rowsInserted > 0;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean addNewStudent(Student student){
        String sql = "INSERT INTO student (full_name, age, email, group_id, enrollmentDate) VALUES (?, ?, ?, ?, ?)";
        try(Connection conn = DataConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, student.getFullName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setInt(4, student.getGroupId());
            stmt.setDate(5, Date.valueOf(student.getEnrollmentDate()));

            return stmt.executeUpdate() > 0;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = DataConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Student student1 = new Student(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getInt("group_id"),
                        rs.getDate("enrollmentDate").toLocalDate(),
                        rs.getInt("courseId")
                );
                students.add(student1);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return students;
    }
    public boolean changeStudent(Student student) {
        String sql = "UPDATE student SET full_name=?, age=?, email=?, group_id=?, enrollmentDate=? WHERE id=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, student.getFullName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setInt(4, student.getGroupId());
            stmt.setDate(5, Date.valueOf(student.getEnrollmentDate()));
            stmt.setInt(6, student.getId());

            return stmt.executeUpdate() > 0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteStudentById(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            return stmt.executeUpdate()>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public List<Student> findStudentTeacherCourses(int courseId) {
        List<Student> student_courses = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE courseId = ?";
        try(Connection conn = DataConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getInt("group_id"),
                        rs.getDate("enrollmentDate").toLocalDate(),
                        rs.getInt("courseId")
                );
                student_courses.add(student);
            }
        }catch (SQLException e)
            {
            e.printStackTrace();
            }
        return student_courses;
    }
    public List<Student> findStudentProfile(String fullName) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE full_name=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, fullName);
            ResultSet rs = stmt.executeQuery();
            stmt.setString(1, students.isEmpty() ? "" : students.get(0).getFullName());
            while (rs.next()){
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getInt("group_id"),
                        rs.getDate("enrollmentDate").toLocalDate(),
                        rs.getInt("courseId")
                );
                students.add(s);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return students;
    }
}
//private int id;
//private String fullName;
//private int age;
//private String email;
//private String group;
//private LocalDate enrollmentDate;