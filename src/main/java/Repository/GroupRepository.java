package Repository;

import db.DataConnection;
import model.Group;
import model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    public boolean addGroup(Group group) {
        String sql = "INSERT INTO groupp (name, curator_id, start_year) VALUES (?, ?, ?)";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, group.getName());
            stmt.setInt(2, group.getCuratorId());
            stmt.setDate(3, Date.valueOf(group.getStartYear()));
            return stmt.executeUpdate()>0;
    }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<Group> getAllGroups() {
        String sql = "SELECT * FROM groupp";
        List<Group> groups = new ArrayList<>();
        try(Connection conn = DataConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Group group = new Group(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getInt("curator_id"),
                  rs.getDate("start_year").toLocalDate()
                );
                groups.add(group);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return groups;
    }
    public boolean deleteGroup(int id) {
        String sql = "DELETE FROM groupp WHERE id=?";
        try(Connection conn = DataConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            return stmt.executeUpdate()>0;
        }catch (Exception e)
            {
            e.printStackTrace();
            }
        return true;
    }
    public List<Group> getTeacherGroups(int curatorId) {
        List<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM groupp WHERE curator_id=?";
        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, curatorId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Group g = new Group(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("curator_id"),
                        rs.getDate("start_year").toLocalDate()
                );
                groups.add(g);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return groups;
    }
}
