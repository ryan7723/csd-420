//Ryan Barber Assignment 8.2 7/12/26

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.Random;

public class RyanBarberThreeThreads extends Application {

    public static final int CHARACTER_COUNT = 10000;
    public static final String SYMBOLS = "!@#$%&*";

    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);

        Scene scene = new Scene(textArea, 800, 500);

        primaryStage.setTitle("Ryan Barber Three Threads");
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread letterThread = new Thread(() -> generateLetterOutput());
        Thread numberThread = new Thread(() -> generateNumberOutput());
        Thread symbolThread = new Thread(() -> generateSymbolOutput());

        letterThread.setName("Letter Thread");
        numberThread.setName("Number Thread");
        symbolThread.setName("Symbol Thread");

        letterThread.setDaemon(true);
        numberThread.setDaemon(true);
        symbolThread.setDaemon(true);

        letterThread.start();
        numberThread.start();
        symbolThread.start();
    }

    private void generateLetterOutput() {

        Random random = new Random();

        for (int i = 0; i < CHARACTER_COUNT; i++) {
            char character = randomLetter(random);
            displayCharacter(character);
            pauseThread(random);
        }
    }

    private void generateNumberOutput() {

        Random random = new Random();

        for (int i = 0; i < CHARACTER_COUNT; i++) {
            char character = randomNumber(random);
            displayCharacter(character);
            pauseThread(random);
        }
    }

    private void generateSymbolOutput() {

        Random random = new Random();

        for (int i = 0; i < CHARACTER_COUNT; i++) {
            char character = randomSymbol(random);
            displayCharacter(character);
            pauseThread(random);
        }
    }

    private void displayCharacter(char character) {
        Platform.runLater(() ->
                textArea.appendText(String.valueOf(character))
        );
    }

    private void pauseThread(Random random) {

        try {
            Thread.sleep(random.nextInt(3));
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    public static char randomLetter(Random random) {
        return (char) ('a' + random.nextInt(26));
    }

    public static char randomNumber(Random random) {
        return (char) ('0' + random.nextInt(10));
    }

    public static char randomSymbol(Random random) {
        return SYMBOLS.charAt(random.nextInt(SYMBOLS.length()));
    }

    public static String generateLetters(int amount) {

        Random random = new Random();
        StringBuilder output = new StringBuilder(amount);

        for (int i = 0; i < amount; i++) {
            output.append(randomLetter(random));
        }

        return output.toString();
    }

    public static String generateNumbers(int amount) {

        Random random = new Random();
        StringBuilder output = new StringBuilder(amount);

        for (int i = 0; i < amount; i++) {
            output.append(randomNumber(random));
        }

        return output.toString();
    }

    public static String generateSymbols(int amount) {

        Random random = new Random();
        StringBuilder output = new StringBuilder(amount);

        for (int i = 0; i < amount; i++) {
            output.append(randomSymbol(random));
        }

        return output.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}