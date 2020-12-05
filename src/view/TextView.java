package view;

import bean.Product;
import util.Gender;
import util.State;

import java.sql.Date;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
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
    public void showSignInFailView() {

    }

    @Override
    public void showSignUpSuccessView() {

    }

    @Override
    public void showDuplicateUsernameView() {

    }

    @Override
    public void showGreet(String username) {

    }

    @Override
    public void showProductList(Map<Product, Integer> products) {

    }

    @Override
    public int showShoppingAction() {
        return 0;
    }

    @Override
    public void showAddToCartFailView(long productId, int stock) {

    }

    @Override
    public int showUserActionView() {
        return 0;
    }

    @Override
    public void showShoppingResult(double totalPrice, Map<Product, Integer> shoppingList) {

    }

    @Override
    public boolean showJoinMembershipView() {
        return false;
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
    public String requireFirstName() {
        return null;
    }

    @Override
    public String requireLastName() {
        return null;
    }

    @Override
    public Gender requireGender() {
        return null;
    }

    @Override
    public Date requireBirthday() {
        return requireDate("Please enter your birthday, press enter if you do not want to tell");
    }

    @Override
    public String requirePhoneNumber() {
        return requireString("Please enter your phone number",
                "Please enter a correct phone number (only numbers)", Pattern.compile("^\\d{10,15}$"));
    }

    @Override
    public String requireLine1() {
        return requireString("Please enter the first line of your address");
    }

    @Override
    public String requireLine2() {
        String input = requireString(
                "Please enter the second line of your address, press enter if there is no second line");
        return "".equals(input) ? null : input;
    }

    @Override
    public String requireLine3() {
        String input = requireString(
                "Please enter the last line of your address, press enter if there is no third line");
        return "".equals(input) ? null : input;
    }

    @Override
    public String requireCity() {
        return requireString("Please enter the city of your address");
    }

    @Override
    public String requireState() {
        String input = requireString("Please enter the state of your address",
                "Please enter a correct state", Pattern.compile("^[a-zA-Z() ]*$"));
        if (Arrays.binarySearch(State.STATES, input) != -1) {
            return input;
        } else {
            System.out.println("Please enter a correct state");
            return requireState();
        }
    }

    @Override
    public String requirePostalCode() {
        return requireString("Please enter your postal code",
                "Please enter a correct postal code (only numbers)",
                Pattern.compile("^\\d{5}([ \\-]\\d{4})?$"));
    }

    @Override
    public long requireProductId() {
        return requireLong("Please enter the id of the item that you want to buy",
                "Please enter a correct id", 1);
    }

    @Override
    public int requireProductAmount() {
        return requireInteger("How many this items you want to buy",
                "Please enter a positive integer", 1);
    }

    @Override
    public String requirePaymentMethod() {
        return requireString("Please enter your payment method");
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
                .collect(Collectors.joining("", "",
                        String.format("0\t%s\nPlease select an action", quit)));
        String errorMessage = String.format("Error: please enter an integer in range from 0 to %d", options.length);
        return requireInteger(instruction, errorMessage, 0, options.length);
    }

    private int requireInteger(String instruction, String errorMessage, int minValue) {
        return requireInteger(instruction, errorMessage, minValue, Integer.MAX_VALUE);
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

    private long requireLong(String instruction, String errorMessage, long minValue) {
        return requireLong(instruction, errorMessage, minValue, Long.MAX_VALUE);
    }

    private long requireLong(String instruction, String errorMessage, long minValue, long maxValue) {
        return requireLong(instruction, errorMessage, minValue, maxValue, null);
    }

    private long requireLong(String instruction, String errorMessage, long minValue, long maxValue, Integer length) {
        System.out.printf("%s: ", instruction);

        String input = scanner.nextLine();
        try {
            if (length != null && length != input.length()) {
                throw new InputMismatchException();
            }

            long number = Long.parseLong(input);
            if (number < minValue || number > maxValue) {
                throw new InputMismatchException();
            }

            return number;
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(errorMessage);
            return requireLong(instruction, errorMessage, minValue, maxValue, length);
        }
    }

    private String requireString(String instruction) {
        System.out.printf("%s: ", instruction);
        return scanner.nextLine();
    }

    private String requireString(String instruction, String errorMessage, Pattern regex) {
        String input = requireString(instruction);
        if (regex.matcher(input).find()) {
            return input;
        } else {
            System.out.println(errorMessage);
            return requireString(instruction, errorMessage, regex);
        }
    }

    private Date requireDate(String instruction) {
        System.out.printf("%s: ", instruction);
        String input = scanner.nextLine();
        if ("".equals(input)) {
            return null;
        }
        try {
            return Date.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a correct date in yyyy-[m]m-[d]d format");
            return requireDate(instruction);
        }
    }
}
