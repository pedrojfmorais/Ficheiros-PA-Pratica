package pt.isec.pa.exCommand£Facade.model.data;

record Product(String name, double qt) {
    @Override
    public String toString() {
        return String.format(
                "%-20s %8.2f",
                name,qt
        );
    }
}
