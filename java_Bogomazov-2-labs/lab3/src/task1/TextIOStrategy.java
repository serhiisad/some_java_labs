package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextIOStrategy extends IOStrategy {

    public TextIOStrategy() {
    }

    @Override
    public ArrayList<Double> readFile(String filename) {
        ArrayList list = new ArrayList<Integer>();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//            String line = reader.readLine();
//            while (line != null) {
////                System.out.println(line);
//                line = reader.readLine();
//                list.add(Integer.parseInt(line));
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {

                list.add(Double.parseDouble(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void writeFile(String filename, ArrayList<Double> list) {
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream(filename, false));
            for (double el : list) {
                el = Math.round(el * 100.0)/100.0;
                output.println(el);
            }
            output.close();
        } catch (Exception ex){
            System.out.printf("Error %s\n", ex);
        }
    }

//    public static void main(String[] args) {
////        System.out.println(System.getProperty("user.dir"));
//        IOStrategy strategy  = new TextIOStrategy();
//        ArrayList<Double> data = strategy.readFile("task1/in.dat");
//        strategy.writeFile("task1/out.dat", data);
//
//    }
}
