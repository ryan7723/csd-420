//Ryan Barber 7/17/26 Assignment 9.2

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudentTable {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/databasedb";
        String username = "student1";
        String password = "pass";

        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    student_id INT PRIMARY KEY,
                    first_name VARCHAR(40),
                    last_name VARCHAR(40),
                    major VARCHAR(60),
                    email VARCHAR(100)
                )
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(url, username, password);

                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(sql);
            System.out.println("The students table was created successfully.");

        } catch (SQLException e) {
            System.out.println("The students table could not be created.");
            e.printStackTrace();
        }
    }
}