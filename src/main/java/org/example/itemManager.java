package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class itemManager {

    private Connection con;

    public itemManager (Connection con){

        this.con=con;
    }

    public void insertitem(String name, int code) throws SQLException {
        String query = "INSERT INTO items(name, code) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, code);
            stmt.execute();
        }


    }

    public item findItem(int code) throws SQLException {
        String query = "SELECT * FROM items WHERE code = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new item(rs.getString("name"), rs.getInt("code"));
                }
            }
        }
        return null;
    }

    public List<item> findItemsByNameContains(String name) throws SQLException {
        String query = "SELECT * FROM items WHERE name LIKE ?";
        List<item> items = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, "%" + name + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new item(rs.getString("name"), rs.getInt("code")));
                }
            }
        }
        return items;
    }


}
