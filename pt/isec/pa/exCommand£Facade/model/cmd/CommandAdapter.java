package pt.isec.pa.exCommand£Facade.model.cmd;

import pt.isec.pa.exCommand£Facade.model.data.ShoppingList;

abstract class CommandAdapter implements ICommand{

    protected ShoppingList shoppingList;

    public CommandAdapter(ShoppingList shoppingList){this.shoppingList = shoppingList;}

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean undo() {
        return false;
    }
}
