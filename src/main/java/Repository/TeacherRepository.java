package Repository;

import db.DataConnection;
import model.Course;
import model.Student;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    public Teacher findByFullName(String fullName) {
        String sql = "SELECT * FROM teacher WHERE full_name=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, fullName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Teacher(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("department"),
                        rs.getString("email")
                );
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean addNewTeacher(Teacher teacher){
        String sql = "INSERT INTO teacher (full_name, department, email) VALUES (?, ?, ?)";
        try(Connection conn = DataConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, teacher.getFullName());
            stmt.setString(2, teacher.getDepartment());
            stmt.setString(3, teacher.getEmail());

            return stmt.executeUpdate() > 0;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<Teacher> findAllTeacher(){
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teacher";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("department"),
                        rs.getString("email")
                );
                teachers.add(teacher);
            }
        }catch (SQLException e)
            {
            e.printStackTrace();
            }
        return teachers;
    }
    public boolean changeTeacher(Teacher teacher) {
        String sql = "UPDATE teacher SET full_name=?, department=?, email=? WHERE id=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, teacher.getFullName());
            stmt.setString(2, teacher.getDepartment());
            stmt.setString(3, teacher.getEmail());
            stmt.setInt(4, teacher.getId());
            return stmt.executeUpdate() > 0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteTeacherById(int id) {
        String sql = "DELETE FROM teacher WHERE id=?";
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
    public List<Teacher> findTeacherProfile(String fullName) {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teacher WHERE full_name=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, fullName);
            ResultSet rs = stmt.executeQuery();
            stmt.setString(1, teachers.isEmpty() ? "" : teachers.get(0).getFullName());
            while (rs.next()){
                Teacher t = new Teacher(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("department"),
                        rs.getString("email")
                );
                teachers.add(t);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return teachers;
    }
}
//private int id;
//public String fullName;
//public String department;
//public String email;