package sample;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class Controller {

    @FXML
    private Button check;

    @FXML
    private TextField input;

    @FXML
    private Label output;

    @FXML
    public void initialize() {
        check.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String text = input.getText();
                if(text.matches("[0-9]+")){
                    Number n = new Number(Integer.parseInt(text));
                    output.setText(n.WriteOutput());
                } else {
                    output.setText("Not a number");
                }
            }
        });
    }
}
