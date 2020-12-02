package view;

public interface View {
    void greet();

    int showIdentityView();

    int showSignView();

    String requireUsername();

    String requirePassword();

    void newPage();

    void exit();
}
