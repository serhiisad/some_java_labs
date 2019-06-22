package task1;

import java.util.ArrayList;

public class DataList {

    private ArrayList<Double> data_list = new ArrayList<>();

    public DataList(){

    }

    public boolean isEmpty(){
        return data_list.isEmpty();
    }

    public ArrayList<Double> getData() {
        return data_list;
    }

    public void setData(ArrayList<Double> data_list) {
        this.data_list = data_list;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return data_list.toString();
    }


}
