package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TextView implements View {
    private final Scanner scanner;

    public TextView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void greet() {
        System.out.println("Welcome to CS460 shopping app.");
    }

    @Override
    public int showIdentityView() {
        System.out.println("Select your identity");
        return requireOption("quit app", "user", "manager");
    }

    @Override
    public int showSignView() {
        return requireOption("back", "sign in", "sign up");
    }

    @Override
    public void showSignInSuccessView() {
        System.out.println("Congratulation! You successfully signed in!");
    }

    @Override
    public String requireUsername() {
        return requireString("Please enter your username");
    }

    @Override
    public String requirePassword() {
        return requireString("Please enter your password");
    }

    @Override
    public void newPage() {
        System.out.println("========================================");
    }

    @Override
    public void exit() {
        System.out.println("Thank you for using CS460 shopping app. Have a good day!");
    }

    private int requireOption(String quit, String... options) {
        String instruction = IntStream.range(0, options.length)
                .mapToObj(i -> String.format("%d\t%s\n", i + 1, options[i]))
                .collect(Collectors.joining("", "", String.format("0\t%s\nPlease select an action", quit)));
        String errorMessage = String.format("Error: please enter an integer in range from 0 to %d", options.length);
        return requireInteger(instruction, errorMessage, 0, options.length);
    }

    private int requireInteger(String instruction, String errorMessage, int minValue, int maxValue) {
        return requireInteger(instruction, errorMessage, minValue, maxValue, null);
    }

    private int requireInteger(String instruction, String errorMessage, int minValue, int maxValue, Integer length) {
        System.out.printf("%s: ", instruction);

        String input = scanner.nextLine();
        try {
            if (length != null && length != input.length()) {
                throw new InputMismatchException();
            }

            int number = Integer.parseInt(input);
            if (number < minValue || number > maxValue) {
                throw new InputMismatchException();
            }

            return number;
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(errorMessage);
            return requireInteger(instruction, errorMessage, minValue, maxValue, length);
        }
    }

    private String requireString(String instruction) {
        System.out.printf("%s: ", instruction);
        return scanner.nextLine();
    }
}
