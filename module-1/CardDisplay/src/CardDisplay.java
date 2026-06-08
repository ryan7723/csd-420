// Ryan Barber Assignment 1.3 6/7/26

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Collections;

public class CardDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        HBox cardBox = new HBox(10);

        Button refreshButton = new Button("Refresh");
        displayCards(cardBox);

        refreshButton.setOnAction(e -> {
            displayCards(cardBox);
        });

        pane.setCenter(cardBox);
        pane.setBottom(refreshButton);

        Scene scene = new Scene(pane, 500, 250);

        primaryStage.setTitle("Playing Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void displayCards(HBox cardBox) {
        cardBox.getChildren().clear();

        ArrayList<Integer> cards = new ArrayList<>();

        for (int i = 1; i <=52; i++) {
            cards.add(i);
        }

        Collections.shuffle(cards);

        for (int i = 0; i < 4; i++) {
            int cardNumber = cards.get(i);

            Image cardImage = new Image ("file:cards/" + cardNumber + ".png");
            ImageView cardView = new ImageView(cardImage);

            cardView.setFitHeight(120);
            cardView.setPreserveRatio(true);

            cardBox.getChildren().add(cardView);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
