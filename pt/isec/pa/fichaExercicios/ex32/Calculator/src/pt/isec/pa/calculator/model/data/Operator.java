package pt.isec.pa.calculator.model.data;

public enum Operator {
    add("+"), sub("-"), mul("*"), div("/"), calc("="), none("");

    String strOp;

    Operator(String strOp) {
        this.strOp = strOp;
    }

    public static Operator getOp(String str) {
        for (Operator op: Operator.values())
            if (op.strOp.equals(str))
                return op;
        return none;
    }
}
