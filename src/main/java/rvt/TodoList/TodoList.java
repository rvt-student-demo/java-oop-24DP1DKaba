package rvt.TodoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TodoList {
    private String databaseUrl;

    public TodoList() {
        this.databaseUrl = "jdbc:sqlite:todo.db";
        createTable();
    }

    public void add(String task) {
        String sql = "INSERT INTO todo(task) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(this.databaseUrl);
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, task);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void print() {
        String sql = "SELECT task FROM todo ORDER BY id";

        try (Connection connection = DriverManager.getConnection(this.databaseUrl);
                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(sql)) {
            int number = 1;

            while (results.next()) {
                System.out.println(number + ": " + results.getString("task"));
                number++;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void remove(int number) {
        String findSql = "SELECT id FROM todo ORDER BY id LIMIT 1 OFFSET ?";
        String deleteSql = "DELETE FROM todo WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(this.databaseUrl);
                PreparedStatement findStatement = connection.prepareStatement(findSql)) {
            findStatement.setInt(1, number - 1);

            try (ResultSet results = findStatement.executeQuery()) {
                if (!results.next()) {
                    return;
                }

                int id = results.getInt("id");

                try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                    deleteStatement.setInt(1, id);
                    deleteStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS todo (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    task TEXT NOT NULL
                )
                """;

        try (Connection connection = DriverManager.getConnection(this.databaseUrl);
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
