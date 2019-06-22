package task1_mvc_pure;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Observer;


abstract class View implements Observer {

    @FXML Label output;
    public void displayResult(String result){}
}

class guiView extends View{


    @Override
    public void update( , Object arg) {
        output.setText((String)arg);
    }

    public guiView() {
        //register
        Obse;
    }

    void setOutput(Label label){
        output = label;
    }

    @Override
    public void displayResult(String result) {
       output.setText(result);
    }


}

class ConsoleView extends View{

    @Override
    public void update(Observable o, Object arg) {

    }

    public ConsoleView() {
    }

    @Override
    public void displayResult(String result) {
        System.out.println("RESULT: " + result);
    }

}