// Ryan Barber 7/26/26 Assignment 10.2

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class favoriteteam extends Application {

    private final TextField idField = new TextField();
    private final TextField firstNameField = new TextField();
    private final TextField lastNameField = new TextField();
    private final TextField favoriteTeamField = new TextField();

    private final Label statusLabel = new Label();

    private static final String URL =
            "jdbc:mysql://localhost:3306/databasedb";

    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    @Override
    public void start(Stage stage) {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("ID:"), 0, 0);
        pane.add(idField, 1, 0);

        pane.add(new Label("First Name:"), 0, 1);
        pane.add(firstNameField, 1, 1);

        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(lastNameField, 1, 2);

        pane.add(new Label("Favorite Team:"), 0, 3);
        pane.add(favoriteTeamField, 1, 3);

        Button displayButton = new Button("Display");
        Button updatebutton =  new Button("Update");

        pane.add(displayButton, 0, 4);
        pane.add(updatebutton, 1, 4);
        pane.add(statusLabel, 0, 5, 2, 1);

        displayButton.setOnAction(event -> displayFan());
        updatebutton.setOnAction(event -> updateFan());

        Scene scene = new Scene(pane, 420, 260);

        stage.setTitle("Fan Database");
        stage.setScene(scene);
        stage.show();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void displayFan() {

        if (!isValidId()) {
            return;
        }

        String sql =
                "SELECT firstname, lastname, favoriteteam " +
                        "FROM fans WHERE ID = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    Integer.parseInt(idField.getText().trim())
            );

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                firstNameField.setText(
                        resultSet.getString("firstname")
                );

                lastNameField.setText(
                        resultSet.getString("lastname")
                );

                favoriteTeamField.setText(
                        resultSet.getString("favoriteteam")
                );

                statusLabel.setText("Record displayed.");
            } else {
                clearFanFields();
                statusLabel.setText("No record found for that ID.");
            }

        } catch (SQLException exception) {
            statusLabel.setText(
                    "Database error: " + exception.getMessage()
            );
        }
    }

    private void updateFan() {

        if (!isValidId()) {
            return;
        }

        if (
                firstNameField.getText().isBlank()
                        || lastNameField.getText().isBlank()
                        || favoriteTeamField.getText().isBlank()
        ) {
            statusLabel.setText(
                    "All fan information fields are required."
            );
            return;
        }

        String sql =
                "UPDATE fans " +
                        "SET firstname = ?, lastname = ?, favoriteteam = ? " +
                        "WHERE ID = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    firstNameField.getText().trim()
            );

            statement.setString(
                    2,
                    lastNameField.getText().trim()
            );

            statement.setString(
                    3,
                    favoriteTeamField.getText().trim()
            );

            statement.setInt(
                    4,
                    Integer.parseInt(idField.getText().trim())
            );

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                statusLabel.setText("Record updated successfully.");
            } else {
                statusLabel.setText("No record found for that ID.");
            }

        } catch (SQLException exception) {
            statusLabel.setText(
                    "Database error: " + exception.getMessage()
            );
        }
    }

    private boolean isValidId() {

        if (idField.getText().isBlank()) {
            statusLabel.setText("Enter a fan ID.");
            return false;
        }

        try {
            Integer.parseInt(idField.getText().trim());
            return true;
        } catch (NumberFormatException exception) {
            statusLabel.setText("ID must be an integer.");
            return false;
        }
    }

    private void clearFanFields() {
        firstNameField.clear();
        lastNameField.clear();
        favoriteTeamField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
