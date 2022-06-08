package pt.isec.pa.gamebw.ui.gui.util;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.util.Timer;
import java.util.TimerTask;

public class ToastMessage {
    private ToastMessage() {}

    public static void show(Window owner, String message) {
        final Popup popup = new Popup();
        popup.setAutoHide(true);
        popup.setAnchorLocation(PopupWindow.AnchorLocation.CONTENT_BOTTOM_LEFT);
        double x = owner.getX();
        double y = owner.getY();
        double w = owner.getWidth();
        double h = owner.getHeight();
        Label lbMessage = new Label(message);

        lbMessage.setTextFill(Color.WHITE);
        BorderPane pane = new BorderPane(lbMessage);
        pane.setPadding(new Insets(10));
        pane.setBackground(new Background(
                new BackgroundFill(Color.color(0.5,0.5,0.5,0.75),
                new CornerRadii(5),Insets.EMPTY))
        );
        popup.getContent().add(pane);
        popup.show(owner,x+w/2-message.length()/2.0*lbMessage.getFont().getSize(),y+0.80*h);
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{popup.hide();});
            }
        };
        timer.schedule(task,3000);
    }
}
