package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grade {
    private int id;
    private int enrrollmentId;
    private int grade_typeId;
    private double grade;



        public Grade(int id, int enrrollmentId, int grade_typeId, double grade) {
            this.id = id;
            this.enrrollmentId = enrrollmentId;
            this.grade_typeId = grade_typeId;
            this.grade = grade;
        }

        public int getId() {
            return id;
        }

        public int getEnrrollmentId() {
            return enrrollmentId;
        }

        public int getGrade_typeId() {
            return grade_typeId;
        }

        public double getgrade() {
            return grade;
        }

        public static void insertGrade(Grade grade){
            Connection con = connection.getConnection();

                String sql = "INSERT INTO grades (id, enrrollment_id,grade_type_id, grade) VALUES (?, ?, ?,?)";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, grade.getId());
                statement.setInt(2, grade.getEnrrollmentId());
                statement.setInt(3, grade.getGrade_typeId());
                statement.setDouble(4, grade.getgrade());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static List<Grade> getAllGrade() {
            Connection con = connection.getConnection();
            List<Grade> grades = new ArrayList<>();

            String sql = "SELECT * FROM grades";

            try (PreparedStatement statement = con.prepareStatement(sql)) {
                ResultSet rs = statement.executeQuery();
                while(rs.next()) {
                   Grade grade= new Grade(
                            rs.getInt("id"),
                            rs.getInt("enrrollment_id"),
                            rs.getInt("grade_type_id"),
                            rs.getInt("grade")
                    );
                    grades.add(grade);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return grades;
        }
    }




