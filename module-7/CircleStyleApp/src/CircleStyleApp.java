//Ryan Barber Assignment 7.2 7/11/26

import com.sun.source.tree.BreakTree;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleApp extends Application {

    public static Circle createPlainCircle() {

        Circle circle = new Circle(30);

        circle.getStyleClass().add("plaincircle");

        return circle;
    }

    public static Circle createColoredCircle(String styleId) {

        Circle circle = new Circle(30);

        circle.setId(styleId);

        return circle;
    }

    // Override start method in Application class.

    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        Circle circle1 = createPlainCircle();
        Circle circle2 = createPlainCircle();
        Circle circle3 = createColoredCircle("redcircle");
        Circle circle4 = createColoredCircle("greencircle");

        hBox.getChildren().addAll(
                circle1,
                circle2,
                circle3,
                circle4
        );

        Scene scene = new Scene(hBox, 350, 150);

        scene.getStylesheets().add(
                getClass().getResource("/mystyle.css").toExternalForm()
        );

        primaryStage.setTitle("Module 7.2 Circle Styles");

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
