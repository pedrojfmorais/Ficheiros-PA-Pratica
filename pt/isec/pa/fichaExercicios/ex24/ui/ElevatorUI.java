package pt.isec.pa.fichaExercicios.ex24.ui;

import pt.isec.pa.fichaExercicios.ex24.model.fsm.ElevatorContext;
import pt.isec.pa.utils.ModelLogs;
import pt.isec.pa.utils.PAInput;

public class ElevatorUI {

    private boolean finish;
    private ElevatorContext fsm;

    public ElevatorUI(ElevatorContext context){
        this.fsm = context;
        this.finish = false;
    }

    public void start(){
        do {
            System.out.println("Current Floor: " + fsm.getFloor());

            System.out.println(ModelLogs.getInstance().getLogs());
            ModelLogs.getInstance().removeAllLogs();

            switch (fsm.getState()){
                case GROUND_FLOOR -> groundFloorUI();
                case FIRST_FLOOR -> firstFloorUI();
                case SECOND_FLOOR -> secondFloorUI();
                case BROKEN -> brokenUI();
            }
        }while(!finish);
    }

    public void groundFloorUI(){
        System.out.println("Ground Floor");
        if(PAInput.chooseOption("Elevator", "Up", "Quit") == 1)
            fsm.up();
        else
            finish = true;
    }

    public void firstFloorUI(){
        System.out.println("1st Floor");
        int op = PAInput.chooseOption("Elevator", "Up", "Down", "Quit");
        switch (op){
            case 1 -> {fsm.up();}
            case 2 -> {fsm.down();}
            default -> {finish = true;}
        }
    }

    public void secondFloorUI(){
        System.out.println("2nd Floor");
        if(PAInput.chooseOption("Elevator", "Down", "Quit") == 1)
            fsm.down();
        else
            finish = true;
    }

    public void brokenUI(){
        System.out.println("Elevator has Broken");
        if(PAInput.chooseOption("Elevator", "Insert Security Key", "Quit") == 1){
            if(!fsm.checkSecurityKey(PAInput.readString("Insert Security key: ", false)))
                System.out.println("Wrong Security Key!");
        }
        else
            finish = true;
    }

}
