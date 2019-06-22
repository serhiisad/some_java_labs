package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Label result;
    @FXML
    private TextField cost;
    @FXML
    private TextArea text;
    @FXML
    private Button calculate;

    EventHandler<Event> handler = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            Receipt r = new Receipt(text.getText());
            if(cost.getText().matches("[0-9]+")) {
                r.setValuePerWord(Integer.parseInt(cost.getText()));
            }
            result.setText("Price for telegram: " + String.valueOf(r.outputReceipt()) + " cents");
        }
    };

    public void initialize() {
        calculate.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }
}
