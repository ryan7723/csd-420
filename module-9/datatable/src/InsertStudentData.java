import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudentData {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/databasedb";
        String username = "student1";
        String password = "pass";

        String sql = """
                INSERT INTO students
                (student_id, first_name, last_name, major, email)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(url, username, password);

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
            addStudent(statement, 1, "Ryan", "Barber",
                    "Software Development", "ryan@example.com");

            addStudent(statement, 2, "Alex", "Morgan",
                    "Cybersecurity", "alex@example.com");

            addStudent(statement, 3, "Jordan", "Lee",
                    "Database Development", "jordan@example.com");

            System.out.println("Student records were inserted successfully.");

        } catch (SQLException e) {
            System.out.println("The student records could not be inserted.");
            e.printStackTrace();
        }
    }

    private static void addStudent(
            PreparedStatement statement,
            int id,
            String firstName,
            String lastName,
            String major,
            String email
    ) throws SQLException {

        statement.setInt(1, id);
        statement.setString(2, firstName);
        statement.setString(3, lastName);
        statement.setString(4, major);
        statement.setString(5, email);
        statement.executeUpdate();
    }
}