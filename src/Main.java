import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double subtotal = 0;


       File itemsFile = new File("items.txt");

        try{
            FileWriter fileWriter = new FileWriter(itemsFile);
            fileWriter.write("10.88");
            fileWriter.write("\n5.62");
            fileWriter.write("\n42.18");
            fileWriter.write("\n0.99");
            fileWriter.write("\n12.37");
            fileWriter.close();

        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        try {
            FileInputStream inputStream = new FileInputStream(itemsFile);
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextDouble()) {
                ArrayList<String> items = new ArrayList<>();
                items.add(scanner.nextLine());
                for (String item : items) {
                    for (int i = 0; i < items.size(); i++) {
                        subtotal = (Double.parseDouble(item) + subtotal);
                        System.out.println("Running subtotal: " + subtotal);
                    }
                }
            }
            scanner.close();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        File totalFile = new File("total.txt");

        double tax = (double) Math.round((subtotal * 0.053) * 100) /100;
        double total = (double) Math.round((subtotal + tax) * 100) /100;

        try{
            FileWriter fileWriter = new FileWriter(totalFile);
            fileWriter.write("\nSubtotal: " + subtotal);
            fileWriter.write("\nTax: " + tax);
            fileWriter.write("\nTotal: " + total);
            fileWriter.close();

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        }
}