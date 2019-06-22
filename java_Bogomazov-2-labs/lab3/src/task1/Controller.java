package task1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.*;
import java.util.ArrayList;

public class Controller {

    private @FXML TextField inputfile;
    private @FXML TextField outputfile;
    private @FXML Button readbtn;
    private @FXML Button writebtn;
    private @FXML Button processbtn;
    private @FXML Button preparebtn;
    private @FXML TextArea logarea;
    private @FXML Label statusLabel;

//    private ArrayList<Double> data_list = new ArrayList<>();
    private DataList list = new DataList();

    @FXML
    protected void handleReadFileAction(ActionEvent event){
        statusLabel.setText("");
        String filename = inputfile.getText();

       if(validateFilename(filename) == "bin"){
           //data_list = new BinIOStrategy().readFile(filename);
           list.setData(new BinIOStrategy().readFile(filename));
       }
       else if(validateFilename(filename) == "txt"){
           //data_list = new TextIOStrategy().readFile(filename);
           list.setData(new TextIOStrategy().readFile(filename));
       }
        else{
            statusLabel.setText("INCORRECT INPUT filepath!");
            return;
        }
        statusLabel.setText("READ success");
        logarea.appendText("Read: " + stringifyData(list.getData()));
        System.out.println("Read: " + stringifyData(list.getData()));
    }

    @FXML
    protected void handleWriteFileAction(ActionEvent event) {
        statusLabel.setText("");
        String filename = outputfile.getText();


        if (validateFilename(filename) == "bin") {
            new BinIOStrategy().writeFile(filename, list.getData());
        } else if (validateFilename(filename) == "txt") {
            new TextIOStrategy().writeFile(filename, list.getData());
        } else {
            statusLabel.setText("INCORRECT OUTPUT filepath!");
            return;
        }
        statusLabel.setText("WRITE success");
        logarea.appendText("Written to " + filename + ": " + stringifyData(list.getData()));
        System.out.println("Written to " + filename + ": " + stringifyData(list.getData()));
    }

    @FXML
    protected void handlePrepareFileAction(ActionEvent event){
        statusLabel.setText("");
        String filename = inputfile.getText();

        if(validateFilename(filename) == "bin"){
            CommonUlits.prepareFile(filename, new BinIOStrategy());
            list.setData(new BinIOStrategy().readFile(filename));
        }
        else if(validateFilename(filename) == "txt"){
            CommonUlits.prepareFile(filename, new TextIOStrategy());
            list.setData(new TextIOStrategy().readFile(filename));
        }
        else{
            statusLabel.setText("INCORRECT OUTPUT filepath!");
            return;
        }

        statusLabel.setText("input FILE PREPARED + \n");
        logarea.appendText("Prepared: " + stringifyData(list.getData()));
        System.out.println("Prepared: " + stringifyData(list.getData()));

    }

    @FXML
    protected void handleProcessNumbers() {
        if(list.isEmpty()) {
            statusLabel.setText("Read the file first!");
        }
        else {
            ArrayList<Double>new_list;
            new_list = CommonUlits.getProcessedNumbers(list.getData());
            System.out.println("before" + list.toString());
//            data_list = new_list;
            list.setData(new_list);

            statusLabel.setText("PROCESS Success + \n");
            logarea.appendText("Processed: " + stringifyData(list.getData()));
            System.out.println("Processed: " + stringifyData(list.getData()));
        }
    }

    private static String validateFilename(String filename){
        if(filename.matches("([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.bin|.dat)$")){
            return "bin";
        }
        else if(filename.matches("([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.txt)$")){
            return "txt";
        }
        else return "none";
    }

    private static String stringifyData(ArrayList<Double>list){
        return list.toString() + "\n";
    }

//    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//
//    }

}
