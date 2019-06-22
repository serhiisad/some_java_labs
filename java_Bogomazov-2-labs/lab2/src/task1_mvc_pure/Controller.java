package task1_mvc_pure;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class Controller extends View {

    @FXML
    private Button check;
    @FXML
    private TextField input;
    @FXML
    private CheckBox box;

    @FXML private Label output;


    private NumberModel model  = new NumberModel();
    private View view = null;

    @FXML public void OnCheckButtonClick(){
        if(box.isSelected()){
            view = new ConsoleView();

        }else{
            view = new guiView();
            ((guiView) view).setOutput(output);
        }

        execute();
    }

    void execute(){
        String text = input.getText();
        if(text.matches("[0-9]+")) {
            model.setNum(Integer.parseInt(text));
            model.checkForPalindrome();
            view.displayResult(model.getResult());
        }
        else{
            view.displayResult("Incorrect input!");
        }

    }
}
