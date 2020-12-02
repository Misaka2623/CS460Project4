package main;

import view.TextView;
import view.View;

public class Main {
    private static final View view = new TextView();

    public static void main(String[] args) {
        view.newPage();
        view.greet();
        view.newPage();
        view.showIdentityView();
    }
}
