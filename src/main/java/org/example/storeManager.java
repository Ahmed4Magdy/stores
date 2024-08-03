package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



    public class storeManager {
        private Connection con;

        public storeManager(Connection con) {
            this.con = con;
        }

        public void insertStore(String name, int code) throws SQLException {
            String query = "INSERT INTO stores(name, code) VALUES (?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setInt(2, code);
                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public store findStore(int code) throws SQLException {
            String query = "SELECT * FROM stores WHERE code = ?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, code);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return new store(rs.getString("name"), rs.getInt("code"));
                    }
                }
            }
            return null;
        }

}
