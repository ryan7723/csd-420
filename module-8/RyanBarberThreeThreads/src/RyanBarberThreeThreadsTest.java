// Ryan Barber Assignment 8.2 7/12/26

public class RyanBarberThreeThreadsTest {

    public static void main(String[] args) {

        int requiredAmount =
                RyanBarberThreeThreads.CHARACTER_COUNT;

        String letters =
                RyanBarberThreeThreads.generateLetters(requiredAmount);

        String numbers =
                RyanBarberThreeThreads.generateNumbers(requiredAmount);

        String symbols =
                RyanBarberThreeThreads.generateSymbols(requiredAmount);

        boolean letterCountTest =
                letters.length() >= requiredAmount;

        boolean numberCountTest =
                numbers.length() >= requiredAmount;

        boolean symbolCountTest =
                symbols.length() >= requiredAmount;

        boolean letterCharacterTest =
                containsOnlyLetters(letters);

        boolean numberCharacterTest =
                containsOnlyNumbers(numbers);

        boolean symbolCharacterTest =
                containsOnlySymbols(symbols);

        System.out.println("Three Threads Test Results");
        System.out.println("--------------------------");

        System.out.println(
                "Letter count test: " + letterCountTest
        );

        System.out.println(
                "Number count test: " + numberCountTest
        );

        System.out.println(
                "Symbol count test: " + symbolCountTest
        );

        System.out.println(
                "Letter character test: " + letterCharacterTest
        );

        System.out.println(
                "Number character test: " + numberCharacterTest
        );

        System.out.println(
                "Symbol character test: " + symbolCharacterTest
        );

        boolean allTestsPassed =
                letterCountTest
                        && numberCountTest
                        && symbolCountTest
                        && letterCharacterTest
                        && numberCharacterTest
                        && symbolCharacterTest;

        System.out.println();
        System.out.println(
                "All tests passed: " + allTestsPassed
        );
    }

    private static boolean containsOnlyLetters(String output) {

        for (int i = 0; i < output.length(); i++) {

            char character = output.charAt(i);

            if (character < 'a' || character > 'z') {
                return false;
            }
        }

        return true;
    }

    private static boolean containsOnlyNumbers(String output) {

        for (int i = 0; i < output.length(); i++) {

            char character = output.charAt(i);

            if (character < '0' || character > '9') {
                return false;
            }
        }

        return true;
    }

    private static boolean containsOnlySymbols(String output) {

        for (int i = 0; i < output.length(); i++) {

            char character = output.charAt(i);

            if (RyanBarberThreeThreads.SYMBOLS
                    .indexOf(character) == -1) {

                return false;
            }
        }

        return true;
    }
}