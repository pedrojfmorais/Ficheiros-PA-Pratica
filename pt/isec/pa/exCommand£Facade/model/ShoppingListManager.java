package pt.isec.pa.exCommand£Facade.model;

import pt.isec.pa.exCommand£Facade.model.cmd.AddProduct;
import pt.isec.pa.exCommand£Facade.model.cmd.CommandManager;
import pt.isec.pa.exCommand£Facade.model.cmd.RemoveProduct;
import pt.isec.pa.exCommand£Facade.model.data.ShoppingList;

public class ShoppingListManager {
    ShoppingList sl;
    CommandManager cm;

    public ShoppingListManager(){
        sl = new ShoppingList();
        cm = new CommandManager();
    }

    public boolean addProduct(String name, double qnt){
        return cm.invokeCommand(new AddProduct(sl, name, qnt));
    }

    public boolean removeProduct(String name, double qnt){
        return cm.invokeCommand(new RemoveProduct(sl, name, qnt));
    }

    public boolean hasUndo() { return cm.hasUndo(); }
    public boolean undo() { return cm.undo(); }

    public boolean hasRedo() { return cm.hasRedo(); }
    public boolean redo() { return cm.redo(); }

    @Override
    public String toString() {
        return sl.toString();
    }
}
