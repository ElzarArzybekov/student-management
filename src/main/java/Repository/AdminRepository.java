package Repository;

import db.DataConnection;
import model.Admin;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepository {
        public Admin findByFullName(String fullName) {
            String sql = "SELECT * FROM admin WHERE username =?";
            try (Connection conn = DataConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, fullName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Admin(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("fullName")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }
}
