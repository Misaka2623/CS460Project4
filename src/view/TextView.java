package view;

import bean.Address;
import bean.Category;
import bean.Employee;
import bean.Group;
import bean.Member;
import bean.Person;
import bean.Product;
import bean.Sale;
import bean.SubSale;
import bean.Supplier;
import bean.Warehouse;
import util.Gender;
import util.State;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
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
    public void newPage() {
        System.out.println("========================================");
    }

    @Override
    public void greet() {
        System.out.println("Welcome to CS460 shopping app!");
    }

    @Override
    public int selectIdentity() {
        System.out.println("Who are you?");
        return requireOption("quit", "user", "manager");
    }

    @Override
    public void exit() {
        System.out.println("Thank you for using CS460 shopping app. Have a good day!");
    }

    @Override
    public int signInOrUp() {
        return requireOption("back", "sign in", "sign up");
    }

    @Override
    public int managerMain() {
        return requireOption("back", "manage addresses", "manage categories", "manage employees",
                "manage groups", "manage members", "manage people", "manage products", "manage sales",
                "manage sub sales", "manage suppliers", "manage warehouses");
    }

    @Override
    public String requireUsername() {
        return requireString("username");
    }

    @Override
    public String requirePassword() {
        return requireString("password");
    }

    @Override
    public void signInSuccess() {
        success("sign in");
    }

    @Override
    public void signInFail() {
        fail("sign in");
    }

    @Override
    public void signUpFail() {
        fail("sign up");
    }

    @Override
    public Member requireMember() {
        Member member = new Member();
        member.setUsername(requireUsername());
        member.setPassword(requirePassword());
        member.setReward(0);
        member.setSuperMember(0);
        return member;
    }

    @Override
    public Person requirePerson() {
        Person person = new Person();
        person.setFirstName(requireFirstName());
        person.setLastName(requireLastName());
        person.setGender(requireGender());
        person.setBirthday(requireBirthday());
        person.setPhone(requirePhone());
        return person;
    }

    @Override
    public Address requireAddress() {
        Address address = new Address();
        address.setLine1(requireLine1());
        address.setLine2(requireLine2());
        address.setLine3(requireLine3());
        address.setCity(requireCity());
        address.setState(requireState());
        address.setPostalCode(requirePostalCode());
        return address;
    }

    @Override
    public void signUpSuccess() {
        success("sign up");
    }

    @Override
    public int manageAddress() {
        return requireOption("back", "add address", "delete address", "list all addresses");
    }

    @Override
    public int manageCategory() {
        return requireOption("back", "add category", "delete category", "list all categories");
    }

    @Override
    public int manageEmployee() {
        return requireOption("back", "add employee", "delete employee", "list all employees");
    }

    @Override
    public int manageGroup() {
        return requireOption("back", "add group", "delete group", "list all groups");
    }

    @Override
    public int manageMember() {
        return requireOption("back", "add member", "delete member", "list all members");
    }

    @Override
    public int managePerson() {
        return requireOption("back", "add person", "delete person", "list all people");
    }

    @Override
    public int manageProduct() {
        return requireOption("back", "add product", "delete product", "list all products");
    }

    @Override
    public int manageSale() {
        return requireOption("back", "add sale", "delete sale", "list all sales");
    }

    @Override
    public int manageSubSale() {
        return requireOption("back", "add sub sale", "delete sub sale", "list all sub sales");
    }

    @Override
    public int manageSupplier() {
        return requireOption("back", "add supplier", "delete supplier", "list all suppliers");
    }

    @Override
    public int manageWarehouse() {
        return requireOption("back", "add warehouse", "delete warehouse", "list all warehouses");
    }

    @Override
    public void greetUser(String firstName, String lastName) {
        System.out.printf("Hello, %s %s!\n", firstName, lastName);
    }

    @Override
    public int userAction() {
        return requireOption("logout", "shopping", "join membership");
    }

    @Override
    public void addAddressFail() {
        fail("add address");
    }

    @Override
    public void addAddressSuccess() {
        success("add address");
    }

    @Override
    public long requireAddressId() {
        return requireId("address");
    }

    @Override
    public void deleteAddressSuccess() {
        success("delete address");
    }

    @Override
    public void deleteAddressFail() {
        fail("delete address");
    }

    @Override
    public void listAddresses(List<Address> addresses) {
        addresses.forEach(System.out::println);
    }

    @Override
    public Category requireCategory() {
        Category category = new Category();
        category.setName(requireCategoryName());
        return category;
    }

    @Override
    public void addCategoryFail() {
        fail("add category");
    }

    @Override
    public void addCategorySuccess() {
        success("add category");
    }

    @Override
    public long requireCategoryId() {
        return requireId("category");
    }

    @Override
    public void deleteCategorySuccess() {
        success("delete category");
    }

    @Override
    public void deleteCategoryFail() {
        fail("delete category");
    }

    @Override
    public void listCategories(List<Category> categories) {
        categories.forEach(System.out::println);
    }

    @Override
    public Employee requireEmployee() {
        Employee employee = new Employee();
        employee.setSalary(requireSalary());
        return employee;
    }

    @Override
    public void addEmployeeFail() {
        fail("add employee");
    }

    @Override
    public void addEmployeeSuccess() {
        success("add employee");
    }

    @Override
    public long requireEmployeeId() {
        return requireId("employee");
    }

    @Override
    public void deleteEmployeeSuccess() {
        success("delete employee");
    }

    @Override
    public void deleteEmployeeFail() {
        fail("delete employee");
    }

    @Override
    public void listEmployees(List<Employee> employees) {
        employees.forEach(System.out::println);
    }

    @Override
    public Group requireGroup() {
        Group group = new Group();
        group.setName(requireGroupName());
        return group;
    }

    @Override
    public void addGroupFail() {
        fail("add group");
    }

    @Override
    public void addGroupSuccess() {
        success("add group");
    }

    @Override
    public long requireGroupId() {
        return requireId("group");
    }

    @Override
    public void deleteGroupSuccess() {
        success("delete group");
    }

    @Override
    public void deleteGroupFail() {
        fail("delete group");
    }

    @Override
    public void listGroups(List<Group> groups) {
        groups.forEach(System.out::println);
    }

    @Override
    public void addMemberFail() {
        fail("add member");
    }

    @Override
    public void addMemberSuccess() {
        success("add member");
    }

    @Override
    public long requireMemberId() {
        return requireId("member");
    }

    @Override
    public void deleteMemberSuccess() {
        success("delete member");
    }

    @Override
    public void deleteMemberFail() {
        fail("delete member");
    }

    @Override
    public void listMembers(List<Member> members) {
        members.forEach(System.out::println);
    }

    @Override
    public void addPersonFail() {
        fail("add person");
    }

    @Override
    public void addPersonSuccess() {
        success("add person");
    }

    @Override
    public long requirePersonId() {
        return requireId("person");
    }

    @Override
    public void deletePersonSuccess() {
        success("delete person");
    }

    @Override
    public void deletePersonFail() {
        fail("delete person");
    }

    @Override
    public void listPeople(List<Person> people) {
        people.forEach(System.out::println);
    }

    @Override
    public Product requireProduct() {
        Product product = new Product();
        product.setName(requireProductName());
        product.setRetailPrice(requireRetailPrice());
        product.setMembershipDiscount(requireMembershipDiscount());
        return product;
    }

    @Override
    public void addProductFail() {
        fail("add product");
    }

    @Override
    public void addProductSuccess() {
        success("add product");
    }

    @Override
    public long requireProductId() {
        return requireId("product");
    }

    @Override
    public void deleteProductSuccess() {
        success("delete product");
    }

    @Override
    public void deleteProductFail() {
        fail("delete product");
    }

    @Override
    public void listProducts(List<Product> products) {
        products.forEach(System.out::println);
    }

    @Override
    public Sale requireSale() {
        Sale sale = new Sale();
        sale.setDate(Date.valueOf(LocalDate.now()));
        sale.setPaymentMethod(requirePaymentMethod());
        sale.setTotalPrice(0);
        sale.setMemberId(requireMemberId());
        return sale;
    }

    @Override
    public void addSaleFail() {
        fail("add sale");
    }

    @Override
    public void addSaleSuccess() {
        success("add sale");
    }

    @Override
    public long requireSaleId() {
        return requireId("sale");
    }

    @Override
    public void deleteSaleSuccess() {
        success("delete sale");
    }

    @Override
    public void deleteSaleFail() {
        fail("delete sale");
    }

    @Override
    public void listSales(List<Sale> sales) {
        sales.forEach(System.out::println);
    }

    @Override
    public SubSale requireSubSale() {
        SubSale subSale = new SubSale();
        subSale.setProductId(requireProductId());
        subSale.setSaleId(requireSaleId());
        subSale.setPrice(requirePrice());
        subSale.setAmount(requireProductAmount());
        return subSale;
    }

    @Override
    public void addSubSaleFail() {
        fail("add sub sale");
    }

    @Override
    public void addSubSaleSuccess() {
        success("add sub sale");
    }

    @Override
    public long requireSubSaleId() {
        return requireId("sub_sale");
    }

    @Override
    public void deleteSubSaleSuccess() {
        success("delete sub sale");
    }

    @Override
    public void deleteSubSaleFail() {
        fail("delete sub sale");
    }

    @Override
    public void listSubSales(List<SubSale> subSales) {
        subSales.forEach(System.out::println);
    }

    @Override
    public Supplier requireSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName(requireSupplierName());
        return supplier;
    }

    @Override
    public void addSupplierFail() {
        fail("add supplier");
    }

    @Override
    public void addSupplierSuccess() {
        success("add supplier");
    }

    @Override
    public long requireSupplierId() {
        return requireId("supplier");
    }

    @Override
    public void deleteSupplierSuccess() {
        success("delete supplier");
    }

    @Override
    public void deleteSupplierFail() {
        fail("supplier fail");
    }

    @Override
    public void listSuppliers(List<Supplier> suppliers) {
        suppliers.forEach(System.out::println);
    }

    @Override
    public Warehouse requireWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setSupplierId(requireSupplierId());
        warehouse.setProductId(requireProductId());
        warehouse.setIncomingDate(requireDate("incoming date"));
        warehouse.setPurchasePrice(requirePurchasePrice());
        warehouse.setAmount(requireProductAmount());
        return warehouse;
    }

    @Override
    public void addWarehouseFail() {
        fail("add warehouse");
    }

    @Override
    public void addWarehouseSuccess() {
        success("add warehouse");
    }

    @Override
    public long requireWarehouseId() {
        return requireId("warehouse");
    }

    @Override
    public void deleteWarehouseSuccess() {
        success("delete warehouse");
    }

    @Override
    public void deleteWarehouseFail() {
        fail("delete warehouse");
    }

    @Override
    public void listWarehouses(List<Warehouse> warehouses) {
        warehouses.forEach(System.out::println);
    }

    @Override
    public String requirePaymentMethod() {
        return requireString("payment method");
    }

    @Override
    public void shoppingResult(double totalPrice, Map<Product, Integer> shoppingList) {
        System.out.printf("%s\t%s\t%s\n", "name", "amount", "price");
        shoppingList.forEach((product, amount) ->
                System.out.printf("%s\t%d\t%.2f\n", product.getName(), amount, product.getRetailPrice() * amount));
        double originalPrice =
                shoppingList.entrySet().stream().mapToDouble(kv -> kv.getKey().getRetailPrice() * kv.getValue()).sum();
        System.out.printf("discount\t%.2f\n", totalPrice - originalPrice);
        System.out.printf("total price\t%.2f\n", totalPrice);
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
        success("join membership");
    }

    @Override
    public int shoppingAction() {
        return requireOption("pay the bill", "show product list", "add product to cart");
    }

    @Override
    public void listProducts(Map<Product, Integer> products) {
        System.out.println("name\tproduct id");
        products.forEach((key, value) -> System.out.printf("%s\t%d\n", key.getName(), value));
    }

    @Override
    public void productIdNotFound(long productId) {
        System.out.printf("product id %d not found\n", productId);
    }

    @Override
    public int requireProductAmount() {
        return requireInteger("product amount", "please enter a positive integer", 1);
    }

    @Override
    public void addToCartFail(long productId, int stock) {
        fail("add to cart");
    }

    private int requireOption(String quit, String... options) {
        String instruction = IntStream.range(0, options.length)
                .mapToObj(i -> String.format("%d\t%s\n", i + 1, options[i]))
                .collect(Collectors.joining("", "",
                        String.format("0\t%s\nPlease select an action", quit)));
        String errorMessage = String.format("Error: please enter an integer in range from 0 to %d", options.length);
        return requireInteger(instruction, errorMessage, 0, options.length);
    }

    private Integer requireInteger(String instruction, String errorMessage) {
        return requireInteger(instruction, errorMessage, null, null, null);
    }

    private Integer requireInteger(String instruction, String errorMessage, Integer minValue) {
        return requireInteger(instruction, errorMessage, minValue, null, null);
    }

    private Integer requireInteger(String instruction, String errorMessage, Integer minValue, Integer maxValue) {
        return requireInteger(instruction, errorMessage, minValue, maxValue, null);
    }

    private Integer requireInteger(String instruction, String errorMessage, Integer minValue, Integer maxValue,
                                   Integer length) {
        System.out.printf("%s: ", instruction);

        String input = scanner.nextLine();
        if ("".equals(input)) {
            return null;
        }
        try {
            if (length != null && length != input.length()) {
                throw new InputMismatchException();
            }

            int inputInt = Integer.parseInt(input);
            if ((minValue != null && minValue > inputInt) || (maxValue != null && maxValue < inputInt)) {
                throw new InputMismatchException();
            }

            return inputInt;
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(errorMessage);
            return requireInteger(instruction, errorMessage, minValue, maxValue, length);
        }
    }

    private Long requireLong(String instruction, String errorMessage) {
        return requireLong(instruction, errorMessage, null, null, null);
    }

    private Long requireLong(String instruction, String errorMessage, Long minValue) {
        return requireLong(instruction, errorMessage, minValue, null, null);
    }

    private Long requireLong(String instruction, String errorMessage, Long minValue, Long maxValue) {
        return requireLong(instruction, errorMessage, minValue, maxValue, null);
    }

    private Long requireLong(String instruction, String errorMessage, Long minValue, Long maxValue, Integer length) {
        System.out.printf("%s: ", instruction);

        String input = scanner.nextLine();
        if ("".equals(input)) {
            return null;
        }
        try {
            if (length != null && length != input.length()) {
                throw new InputMismatchException();
            }

            long inputLong = Long.parseLong(input);
            if ((minValue != null && minValue > inputLong) || (maxValue != null && maxValue < inputLong)) {
                throw new InputMismatchException();
            }

            return inputLong;
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(errorMessage);
            return requireLong(instruction, errorMessage, minValue, maxValue, length);
        }
    }

    private Double requireDouble(String instruction, String errorMessage) {
        return requireDouble(instruction, errorMessage, null, null);
    }

    private Double requireDouble(String instruction, String errorMessage, Double minValue) {
        return requireDouble(instruction, errorMessage, minValue, null);
    }

    private Double requireDouble(String instruction, String errorMessage, Double minValue, Double maxValue) {
        System.out.printf("%s: ", instruction);

        String input = scanner.nextLine();
        if ("".equals(input)) {
            return null;
        }
        try {
            double inputDouble = Double.parseDouble(input);
            if ((minValue != null && minValue > inputDouble) || (maxValue != null && maxValue < inputDouble)) {
                throw new InputMismatchException();
            }

            return inputDouble;
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(errorMessage);
            return requireDouble(instruction, errorMessage, minValue, maxValue);
        }
    }

    private String requireString(String instruction) {
        return requireString(instruction, null, null);
    }

    private String requireString(String instruction, String errorMessage, Pattern regex) {
        System.out.printf("%s: ", instruction);
        String input = scanner.nextLine();
        if (regex == null || regex.matcher(input).find()) {
            return input;
        } else {
            System.out.println(errorMessage);
            return requireString(instruction, errorMessage, regex);
        }
    }

    private void success(String action) {
        System.out.printf("%s success\n", action);
    }

    private void fail(String action) {
        System.out.printf("%s fail\n", action);
    }

    private String requireFirstName() {
        return requireString("first name");
    }

    private String requireLastName() {
        return requireString("last name");
    }

    private Gender requireGender() {
        StringBuilder instruction = new StringBuilder();
        instruction.append("gender (");
        for (Gender gender : Gender.values()) {
            instruction.append(gender.name().toLowerCase()).append(", ");
        }
        instruction.delete(instruction.length() - 2, instruction.length()).append(")");
        String input = requireString(instruction.toString());
        if (input == null || "".equals(input)) {
            return Gender.UNKNOWN;
        }
        try {
            return Gender.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a correct gender");
            return requireGender();
        }
    }

    private Date requireBirthday() {
        return requireDate("birthday");
    }

    private String requirePhone() {
        return requireString("phone", "Please enter a correct phone number (only numbers)",
                Pattern.compile("^\\d{10,15}$"));
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

    private String requireLine1() {
        return requireString("line1");
    }

    private String requireLine2() {
        return requireString("line2");
    }

    private String requireLine3() {
        return requireString("line3");
    }

    private String requireCity() {
        return requireString("city");
    }

    private String requireState() {
        String input = requireString("Please enter the state of the address",
                "Please enter a correct state", Pattern.compile("^[a-zA-Z() ]*$"));
        int index = Arrays.binarySearch(State.STATES, input);
        if (index != -1) {
            if (index % 2 == 0) {
                index += 1;
            }
            return State.STATES[index];
        } else {
            System.out.println("Please enter a correct state");
            return requireState();
        }
    }

    private String requirePostalCode() {
        return requireString("postal code", "Please enter a correct postal code (only numbers)",
                Pattern.compile("^\\d{5}([ \\-]\\d{4})?$"));
    }

    private long requireId(String name) {
        return requireLong(String.format("%s id", name), "please enter a correct id", 1L);
    }

    private String requireCategoryName() {
        return requireString("category name");
    }

    private double requireSalary() {
        return requireDouble("salary", "please enter a correct salary", .0);
    }

    private String requireGroupName() {
        return requireString("group name");
    }

    private String requireProductName() {
        return requireString("product name");
    }

    private double requireRetailPrice() {
        return requireDouble("retail price", "please enter a correct price", .0);
    }

    private double requireMembershipDiscount() {
        return requireDouble("membership discount", "please enter a correct discount", .0);
    }

    private double requirePrice() {
        return requireDouble("price", "please enter a correct price", .0);
    }

    private String requireSupplierName() {
        return requireString("supplier name");
    }

    private double requirePurchasePrice() {
        return requireDouble("price", "please enter a correct price", .0);
    }
}
