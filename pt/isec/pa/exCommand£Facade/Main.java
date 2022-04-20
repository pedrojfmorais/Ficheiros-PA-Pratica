package pt.isec.pa.exCommand£Facade;

import pt.isec.pa.exCommand£Facade.model.ShoppingListManager;
import pt.isec.pa.exCommand£Facade.ui.ShoppingListUI;

public class Main {
    public static void main(String[] args) {
        ShoppingListManager slm = new ShoppingListManager();
        ShoppingListUI ui = new ShoppingListUI(slm);

        ui.start();
    }
}
