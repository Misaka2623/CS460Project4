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
                // TODO: 12/1/20
            case 2:
                // TODO: 12/1/20
            default:
                throw new IllegalStateException();
        }
    }
}
