package pt.isec.pa.exerc30.ui.gui;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pt.isec.pa.exerc30.model.DrawingManager;

import java.io.File;

public class AppMenu extends MenuBar {

    DrawingManager drawing;

    Menu mnFile;
    MenuItem miNew, miOpen, miSave, miExit;

    Menu mnEdit;
    MenuItem mIUndo, miRedo;

    public AppMenu(DrawingManager drawing){
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        mnFile = new Menu("File");
            miNew = new MenuItem("New");
            miNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
            miOpen = new MenuItem("Open");
            miOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
            miSave = new MenuItem("Save");
            miSave.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
            miExit = new MenuItem("Exit");
            miExit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        mnFile.getItems().addAll(miNew, miOpen, miSave, miExit);

        mnEdit = new Menu("Edit");
            mIUndo = new MenuItem("Undo");
            mIUndo.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
            miRedo = new MenuItem("Redo");
            miRedo.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        mnEdit.getItems().addAll(mIUndo, miRedo);

        this.getMenus().addAll(mnFile, mnEdit);
        this.setUseSystemMenuBar(true);

    }

    private void registerHandlers() {
        //TODO: init
        miNew.setOnAction(actionEvent -> drawing.clearAll());

        miOpen.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("File open...");
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Drawing (*.dat)", "*.dat"),
                    new FileChooser.ExtensionFilter("All", "*")
            );

            File hFile = fileChooser.showOpenDialog(this.getScene().getWindow());

            if(hFile != null)
                drawing.load(hFile);
        } );
        miSave.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("File open...");
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Drawing (*.dat)", "*.dat"),
                    new FileChooser.ExtensionFilter("All", "*")
            );

            File hFile = fileChooser.showSaveDialog(this.getScene().getWindow());

            if(hFile != null)
                drawing.save(hFile);

        } );

        miExit.setOnAction(actionEvent -> Platform.exit());

        //TODO
        mIUndo.setOnAction(actionEvent -> {});

        //TODO
        miRedo.setOnAction(actionEvent -> {});
    }

    private void update() {
        //TODO: drawing.hasUndo
        mIUndo.setDisable(true);
        //TODO: drawing.hasRedo
//        mIUndo.setDisable(true);
    }

}
