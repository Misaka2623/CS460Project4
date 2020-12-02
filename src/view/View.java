package view;

import util.Gender;

import java.sql.Date;
import java.util.List;

public interface View {
    void greet();

    int showIdentityView();

    int showSignView();

    void showSignInSuccessView();

    void showSignInFailView();

    void showSignUpSuccessView();

    void showDuplicateUsernameView();

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
}
