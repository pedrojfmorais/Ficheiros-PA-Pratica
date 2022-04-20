package pt.isec.pa.exCommand£Facade.model.cmd;

import pt.isec.pa.exCommand£Facade.model.data.ShoppingList;

public class RemoveProduct extends CommandAdapter{

    private final String name;
    private final double qnt;

    public RemoveProduct(ShoppingList shoppingList, String name, double qnt) {
        super(shoppingList);
        this.name = name;
        this.qnt = qnt;
    }

    @Override
    public boolean execute() {
        return shoppingList.removeProduct(name, qnt);
    }

    @Override
    public boolean undo() {
        return shoppingList.addProduct(name, qnt);
    }
}
