package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grade_type {
    private int id;
    private String name;
    private double weight;

    public Grade_type(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
    public static void insertGrade_type(Grade_type grade_type) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO grade_type (id, name, weight) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, grade_type.getId());
            statement.setString(2, grade_type.getName());
            statement.setDouble(3, grade_type.getWeight());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Grade_type> getAllGrade_type() {
        Connection con = connection.getConnection();
        List<Grade_type> grade_types = new ArrayList<>();

        String sql = "SELECT * FROM grade_type";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Grade_type gradetype = new Grade_type(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight")

                );
                grade_types.add(gradetype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade_types;
    }

}
