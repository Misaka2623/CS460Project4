package view;

import bean.Address;
import bean.Product;
import util.Gender;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface View {
    void greet();

    int selectIdentity();

    int signInOrUp();

    void signInSuccess();

    void signInFail();

    void signUpSuccess();

    void duplicateUsername();

    void greetUser(String username);

    void listProducts(Map<Product, Integer> products);

    int shoppingAction();

    void addToCartFail(long productId, int stock);

    int userAction();

    void shoppingResult(double totalPrice, Map<Product, Integer> shoppingList);

    void productIdNotFound(long productId);

    boolean joinMembership();

    void joinMembershipSuccess();

    String requireUsername();

    String requirePassword();

    String requireFirstName();

    String requireLastName();

    Gender requireGender();

    Date requireBirthday();

    String requirePhoneNumber();

    String requireLine1();

    String requireLine2();

    String requireLine3();

    String requireCity();

    String requireState();

    String requirePostalCode();

    long requireProductId();

    int requireProductAmount();

    String requirePaymentMethod();

    void newPage();

    void exit();

    int managerMain();

    int manageAddress();

    int manageCategory();

    int manageEmployee();

    int manageGroup();

    int manageMember();

    int managePerson();

    int manageProduct();

    int manageSale();

    int manageSubSale();

    int manageSupplier();

    int manageWarehouse();

    void addAddressSuccess();

    long requireAddressId();

    void deleteAddressSuccess();

    void deleteAddressFail();

    void listAddresses(List<Address> addresses);

    String requireCategoryName();

    void addCategoryFail();

    void addCategorySuccess();

    long requireCategoryId();

    void deleteCategorySuccess();

    void deleteCategoryFail();

    void addAddressFail();

    Address requireAddress();
}
