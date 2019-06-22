package task1;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class BinIOStrategy extends IOStrategy {

    public BinIOStrategy() {
    }

    @Override
    public ArrayList<Double> readFile(String filename) {

        ArrayList<Double> list = new ArrayList<>();
        try (BufferedReader input = openFile(filename)) {
            String line;
            while ((line = input.readLine()) != null) {

                System.out.println(line);
                //TODO
                double doubleVal = Double.longBitsToDouble(new BigInteger(line, 2).longValue());
                System.out.println(doubleVal);
                list.add(Math.round(doubleVal*100.0)/100.0);
            }
            if (list.isEmpty()) throw new ValueException("List is empty!");
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }


    private static BufferedReader openFile(String fileName)
            throws IOException {
                 return new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(fileName), StandardCharsets.UTF_8));
    }

    @Override
    public void writeFile(String filename, ArrayList<Double> data) {
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter(filename, false));
            for (double el : data) {
                el = Math.round(el * 100.0)/100.0;
                output.write(Long.toBinaryString(Double.doubleToRawLongBits(el))+"\n");
            }
            output.close();
        } catch (Exception ex){
            System.out.printf("Error while writing to file %s\n", ex);
        }
    }

}
