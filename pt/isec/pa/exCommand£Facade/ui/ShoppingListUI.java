package pt.isec.pa.exCommand£Facade.ui;

import pt.isec.pa.exCommand£Facade.model.ShoppingListManager;
import pt.isec.pa.utils.PAInput;

public class ShoppingListUI {
    ShoppingListManager sm;
    public ShoppingListUI(ShoppingListManager sm) { this.sm = sm; }
    public void start() {
        boolean finish = false;
        do {
            System.out.println("\n\n"+sm+"\n");
            int op = PAInput.chooseOption("Shopping List",
                    "Add product","Remove product","Undo","Redo","Quit");
            switch (op) {
                case 1 -> sm.addProduct(
                        PAInput.readString("Product name: ",false),
                        PAInput.readNumber("Quantity: ") );
                case 2 -> sm.removeProduct(
                        PAInput.readString("Product name: ",false),
                        PAInput.readNumber("Quantity: ") );
                case 3 -> sm.undo();
                case 4 -> sm.redo();
                case 5 -> finish = true;
            }
        } while (!finish);
    }
}
