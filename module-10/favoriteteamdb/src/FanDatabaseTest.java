import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FanDatabaseTest {

    private static final String URL =
            "jdbc:mysql://localhost:3306/databasedb";

    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {

        System.out.println("Starting Fan Database tests...\n");

        testDatabaseConnection();
        testDisplayRecord();
        testUpdateRecord();

        System.out.println("\nAll tests completed.");
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void testDatabaseConnection() {
        System.out.println("Test 1: Database connection");

        try (Connection connection = getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("PASS: Connected to databasedb.");
            } else {
                System.out.println("FAIL: Connection was not established.");
            }
        } catch (SQLException exception) {
            System.out.println(
                    "FAIL: " + exception.getMessage()
            );
        }
    }

    private static void testDisplayRecord() {
        System.out.println("\nTest 2: Display record");

        String sql =
                "SELECT firstname, lastname, favoriteteam " +
                        "FROM fans WHERE ID = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
            statement.setInt(1, 1);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("PASS: Record found.");

                    System.out.println(
                            "Name: "
                                    + resultSet.getString("firstname")
                                    + " "
                                    + resultSet.getString("lastname")
                    );

                    System.out.println(
                            "Favorite Team: "
                                    + resultSet.getString("favoriteteam")
                    );
                } else {
                    System.out.println(
                            "FAIL: Record with ID 1 was not found."
                    );
                }
            }
        } catch (SQLException exception) {
            System.out.println(
                    "FAIL: " + exception.getMessage()
            );
        }
    }

    private static void testUpdateRecord() {
        System.out.println("\nTest 3: Update record");

        String selectSql =
                "SELECT favoriteteam FROM fans WHERE ID = ?";

        String updateSql =
                "UPDATE fans SET favoriteteam = ? WHERE ID = ?";

        try (Connection connection = getConnection()) {

            String originalTeam;

            try (
                    PreparedStatement selectStatement =
                            connection.prepareStatement(selectSql)
            ) {
                selectStatement.setInt(1, 3);

                try (
                        ResultSet resultSet =
                                selectStatement.executeQuery()
                ) {
                    if (!resultSet.next()) {
                        System.out.println(
                                "FAIL: Record with ID 3 was not found."
                        );
                        return;
                    }

                    originalTeam =
                            resultSet.getString("favoriteteam");
                }
            }

            String temporaryTeam = "Test Team";

            try (
                    PreparedStatement updateStatement =
                            connection.prepareStatement(updateSql)
            ) {
                updateStatement.setString(1, temporaryTeam);
                updateStatement.setInt(2, 3);

                int rowsUpdated =
                        updateStatement.executeUpdate();

                if (rowsUpdated != 1) {
                    System.out.println(
                            "FAIL: Record was not updated."
                    );
                    return;
                }
            }

            try (
                    PreparedStatement selectStatement =
                            connection.prepareStatement(selectSql)
            ) {
                selectStatement.setInt(1, 3);

                try (
                        ResultSet resultSet =
                                selectStatement.executeQuery()
                ) {
                    if (!resultSet.next()) {
                        System.out.println(
                                "FAIL: Record with ID 3 was not found."
                        );
                        return;
                    }

                    originalTeam =
                            resultSet.getString("favoriteteam");
                }
            }

            try (
                    PreparedStatement updateStatement =
                            connection.prepareStatement(updateSql)
            ) {
                updateStatement.setString(1, temporaryTeam);
                updateStatement.setInt(2, 3);

                int rowsUpdated =
                        updateStatement.executeUpdate();

                if (rowsUpdated != 1) {
                    System.out.println(
                            "FAIL: Record was not updated."
                    );
                    return;
                }
            }

            try (
                    PreparedStatement selectStatement =
                            connection.prepareStatement(selectSql)
            ) {
                selectStatement.setInt(1, 3);

                try (
                        ResultSet resultSet =
                                selectStatement.executeQuery()
                ) {
                    resultSet.next();

                    String updatedTeam =
                            resultSet.getString("favoriteteam");

                    if (temporaryTeam.equals(updatedTeam)) {
                        System.out.println(
                                "PASS: Update was saved to the database."
                        );
                    } else {
                        System.out.println(
                                "FAIL: Updated value was not saved."
                        );
                    }
                }
            }

            try (
                    PreparedStatement restoreStatement =
                            connection.prepareStatement(updateSql)
            ) {
                restoreStatement.setString(1, originalTeam);
                restoreStatement.setInt(2, 3);
                restoreStatement.executeUpdate();

                System.out.println(
                        "Original database value restored."
                );
            }

        } catch (SQLException exception) {
            System.out.println(
                    "FAIL: " + exception.getMessage()
            );
        }
    }
}