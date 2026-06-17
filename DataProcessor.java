import java.io.*;
import java.util.*;

public class DataProcessor {
    // Method to read data from file
    public ArrayList<Double> readAndValidateValues() {
        ArrayList<Double> fileValues = new ArrayList<>();

        try {
            File inputFile = new File("input.txt");

            if (!inputFile.exists()) {
                throw new FileNotFoundException(
                        "Exception: FileNotFoundException - The file input.txt does not exist.");
            }

            Scanner sc = new Scanner(inputFile);
            InvalidDataException caughtException = null;

            int count = 0;

            while (sc.hasNext()) {
                String value = sc.next();

                try {
                    fileValues.add(Double.parseDouble(value));
                    count++;
                } catch (NumberFormatException e) {
                    caughtException = new InvalidDataException("\"" + value + "\" is not a valid number.");

                    if (caughtException != null) {
                        System.out.println("Exception: InvalidDataException - " + caughtException.getMessage());
                    }
                }
            }

            sc.close();

            if (count == 0) {
                throw new IllegalArgumentException(
                        "Exception: IllegalArgumentException - No numeric values found in the file");
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return fileValues;
    }

    // Method to calculate the average
    public double getAverage(ArrayList<Double> numbers) {
        double sum = 0.0;
        int count = 0;

        for (double number : numbers) {
            sum = sum + number;
            count++;
        }

        return (sum / count);
    }

    // Method to write to the average to a file
    public void writeToFile(double average) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(String.valueOf(average));

            writer.close();

        } catch (IOException e) {
            System.out.println("Exception: IOException - Could not write to the file output.txt.");
        }
    }
}
