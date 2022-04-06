package pt.isec.pa.fichaExercicios.ex24.model.data;

public class Elevator {

    private int currentFloor;
    private final String securityKey;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.securityKey = "asd";
    }

    public boolean checkSecurityKey(String str){return securityKey.equals(str);}

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                '}';
    }
}
