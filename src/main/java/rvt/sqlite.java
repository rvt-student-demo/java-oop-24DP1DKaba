package rvt;
import java.sql.*;

public class sqlite {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db");
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS todo (
                    id INTEGER PRIMARY KEY,
                    task TEXT
                )
            """);

            stmt.executeUpdate("INSERT INTO todo(task) VALUES ('Make a dance!')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}