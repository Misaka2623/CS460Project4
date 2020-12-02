package main;

import view.TextView;
import view.View;

public class Main {
    private static final View view = new TextView();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        view.newPage();
        view.greet();
        recognizeIdentity();
    }

    private static void recognizeIdentity() {
        view.newPage();
        int option = view.showIdentityView();
        switch (option) {
            case 0:
                view.newPage();
                view.exit();
                return;
            case 1:
                signInOrUp();
                break;
            case 2:
                // TODO: 12/1/20
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private static void signInOrUp() {
        view.newPage();
        int option = view.showSignView();
        switch (option) {
            case 0:
                return;
            case 1:
                // TODO: 12/1/20
                break;
            case 2:
                // TODO: 12/1/20
                break;
            default:
                throw new IllegalStateException();
        }
    }
}
