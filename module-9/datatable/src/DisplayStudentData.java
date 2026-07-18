import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayStudentData {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/databasedb";
        String username = "student1";
        String password = "pass";

        String sql = "SELECT * FROM students";

        try (
                Connection connection =
                        DriverManager.getConnection(url, username, password);

                Statement statement = connection.createStatement();

                ResultSet results = statement.executeQuery(sql)
        ) {
            System.out.println("Connection established successfully.");
            System.out.println();

            while (results.next()) {
                System.out.println(
                        "Student ID: " + results.getInt("student_id"));

                System.out.println(
                        "Name: " + results.getString("first_name")
                                + " " + results.getString("last_name"));

                System.out.println(
                        "Major: " + results.getString("major"));

                System.out.println(
                        "Email: " + results.getString("email"));

                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("The student records could not be displayed.");
            e.printStackTrace();
        }
    }
}