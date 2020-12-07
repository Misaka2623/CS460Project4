package view;

import bean.Address;
import bean.Product;
import util.Gender;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface View {
    void greet();

    int showIdentityView();

    int showSignView();

    void showSignInSuccessView();

    void showSignInFailView();

    void showSignUpSuccessView();

    void showDuplicateUsernameView();

    void showGreet(String username);

    void showProductList(Map<Product, Integer> products);

    int showShoppingAction();

    void showAddToCartFailView(long productId, int stock);

    int showUserActionView();

    void showShoppingResult(double totalPrice, Map<Product, Integer> shoppingList);

    void showProductIdNotFoundView(long productId);

    boolean showJoinMembershipView();

    void showJoinMembershipSuccessView();

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

    int showManagerMainView();

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

    void showInsertAddressSuccessView();

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
}
