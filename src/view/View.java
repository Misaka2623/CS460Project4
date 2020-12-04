package view;

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

    List<Long> showShoppingPage();

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

    void newPage();

    void exit();

    long requireProductId();

    int requireProductAmount();

    void showAddToCartFailView(long productId, int stock);

    String requirePaymentMethod();

    int showUserActionView();

    void showShoppingResult(double totalPrice, Map<Product, Integer> shoppingList);
}
