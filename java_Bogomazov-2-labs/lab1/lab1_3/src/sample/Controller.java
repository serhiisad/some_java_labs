package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Button generate;
    @FXML
    private TextField length;
    @FXML
    private Label lblSum;
    @FXML
    private Label min;
    @FXML
    private Label arr;

    private Array array;

    @FXML
    public void initialize(){
        generate.addEventHandler(MouseEvent.MOUSE_CLICKED ,new GeneratorHandler());
        length.addEventHandler(KeyEvent.KEY_PRESSED, new KeyGeneratorHandler());
    }

    class KeyGeneratorHandler implements EventHandler<KeyEvent> {

        public void handle(KeyEvent e){
            if(e.getCode().equals(KeyCode.ENTER)) {
                generate();
            }
        }
    }

    class GeneratorHandler implements EventHandler<Event> {

        public void handle(Event e){
            generate();
        }
    }

    public void generate() {
        if(length.getText().matches("[0-9]+") && length.getText().length() <= 2) {
            array = new Array(Integer.parseInt(length.getText()));
            arr.setText(array.toString());
            min.setText(String.valueOf(array.minimalPosition()));
            lblSum.setText(String.valueOf(array.sumBetweenFirstNegative()));
        } else {
            arr.setText("Not a number");
        }
    }


}
