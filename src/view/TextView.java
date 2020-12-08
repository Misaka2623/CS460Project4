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
    public int selectIdentity() {
        System.out.println("Select your identity");
        return requireOption("quit app", "user", "manager");
    }

    @Override
    public int signInOrUp() {
        return requireOption("back", "sign in", "sign up");
    }

    @Override
    public void signInSuccess() {
        System.out.println("Congratulation! You successfully signed in!");
    }

    @Override
    public void signInFail() {
        System.out.println("Sorry, the username and password do not match.");
    }

    @Override
    public void signUpSuccess() {
        System.out.println("Congratulation, sign up success!");
    }

    @Override
    public void duplicateUsername() {
        System.out.println("The username you entered is already exist, please use a new username.");
    }

    @Override
    public void greetUser(String firstName, String lastName) {
        System.out.printf("Welcome, %s %s!\n", firstName, lastName);
    }

    @Override
    public void listProducts(Map<Product, Integer> products) {
        int maxLength = Math.max("product".length(),
                products.keySet().stream().mapToInt(product -> product.getName().length()).max().orElse(0));
        System.out.printf(String.format("%% %ds\t product id\n", maxLength), "name");
        products.forEach((key, value) ->
                System.out.printf(String.format("%% %ds\t %%d\n", maxLength), key.getName(), value));
    }

    @Override
    public int shoppingAction() {
        return requireOption("pay the bill", "show product list", "add product to cart");
    }

    @Override
    public void addToCartFail(long productId, int stock) {
        System.out.printf("The product %d only has %d in stock, please enter a valid amount.\n", productId, stock);
    }

    @Override
    public int userAction() {
        return requireOption("logout", "shopping", "become a super member");
    }

    @Override
    public void shoppingResult(double totalPrice, Map<Product, Integer> shoppingList) {
        int nameLength = Math.max("discount".length(),
                shoppingList.keySet().stream().mapToInt(product -> product.getName().length()).max().orElse(0));

        int amountLength = Math.max("amount".length(),
                shoppingList.values().stream().mapToInt(i -> String.valueOf(i).length()).max().orElse(0));

        System.out.printf(
                String.format("%% %ds %% %ds\t %%s\n", nameLength, amountLength), "product", "amount", "price");
        shoppingList.forEach((key, value) ->
                System.out.printf(String.format("%% %ds %% %dd\t %%.2f\n", nameLength, amountLength),
                        key.getName(), value, key.getRetailPrice() * value)
        );
        System.out.println();

        double price =
                shoppingList.entrySet().stream().mapToDouble(kv -> kv.getKey().getRetailPrice() * kv.getValue()).sum();
        double discount = totalPrice - price;
        System.out.printf(String.format("%% %ds %% %ds\t-%%.2f\n", nameLength, amountLength), "discount", "", discount);
        System.out.printf(String.format("%% %ds %% %ds\t %%.2f\n", nameLength, amountLength), "total", "", totalPrice);
    }

    @Override
    public void productIdNotFound(long productId) {
        System.out.printf("The id %d you entered does not refer any product in the list.\n", productId);
    }

    @Override
    public boolean joinMembership() {
        char input = requireString(
                "To join our membership, you will get membership discount when you buy any product. You will " +
                        "also get 1 point for each dollar you spend. You can redeem $1 store credit using 100 reward " +
                        "point. To join the membership, you need to pay $5 fee each month. Are you sure you want to " +
                        "join our membership? (Y/N)", "Please enter \"Y\" or \"N\"",
                Pattern.compile("^[YN]$", Pattern.CASE_INSENSITIVE)).toLowerCase().charAt(0);
        return input == 'y';
    }

    @Override
    public void joinMembershipSuccess() {
        System.out.println("Congratulation! You are our super member now!");
    }

    @Override
    public String requireUsername() {
        return requireString("Please enter the username");
    }

    @Override
    public String requirePassword() {
        return requireString("Please enter the password");
    }

    @Override
    public String requireFirstName() {
        return requireString("Please enter the first name", "Please enter a valid name",
                Pattern.compile("^[a-zA-Z. ]*$"));
    }

    @Override
    public String requireLastName() {
        return requireString("Please enter the last name", "Please enter a valid name",
                Pattern.compile("^[a-zA-Z. ]*$"));
    }

    @Override
    public Gender requireGender() {
        StringBuilder instruction = new StringBuilder();
        instruction.append("Please enter the gender (");
        for (Gender gender : Gender.values()) {
            instruction.append(gender.name().toLowerCase()).append(", ");
        }
        instruction.delete(instruction.length() - 2, instruction.length()).append(")");
        String input = requireString(instruction.toString());
        try {
            return Gender.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a correct gender");
            return requireGender();
        }
    }

    @Override
    public Date requireBirthday() {
        return requireDate("Please enter the birthday, press enter if you do not want to tell");
    }

    @Override
    public String requirePhoneNumber() {
        return requireString("Please enter the phone number",
                "Please enter a correct phone number (only numbers)", Pattern.compile("^\\d{10,15}$"));
    }

    @Override
    public String requireLine1() {
        return requireString("Please enter the first line of the address");
    }

    @Override
    public String requireLine2() {
        String input = requireString(
                "Please enter the second line of the address, press enter if there is no second line");
        return "".equals(input) ? null : input;
    }

    @Override
    public String requireLine3() {
        String input = requireString(
                "Please enter the last line of the address, press enter if there is no third line");
        return "".equals(input) ? null : input;
    }

    @Override
    public String requireCity() {
        return requireString("Please enter the city of the address");
    }

    @Override
    public String requireState() {
        String input = requireString("Please enter the state of the address",
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
        return requireString("Please enter the postal code",
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
        return requireString("Please enter the payment method");
    }

    @Override
    public void newPage() {
        System.out.println("========================================");
    }

    @Override
    public void exit() {
        System.out.println("Thank you for using CS460 shopping app. Have a good day!");
    }

    @Override
    public int managerMain() {
        return requireOption("back", "manage addresses", "manage categories", "manage employees",
                "manage groups", "manage members", "manage people", "manage products", "manage sales",
                "manage sub sales", "manage suppliers", "manage warehouses");
    }

    @Override
    public int manageAddress() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageCategory() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageEmployee() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageGroup() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageMember() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int managePerson() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageProduct() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageSale() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageSubSale() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageSupplier() {
        return requireOption("back", "add record", "delete record", "list all records");
    }

    @Override
    public int manageWarehouse() {
        return requireOption("back", "add record", "delete record", "list all records");
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
