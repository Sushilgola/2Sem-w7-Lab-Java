
/**
 * Problem 2: Data Validation
 * You need to develop a module for a data validation tool that reads numeric
 * values from a text file and validates them. Invalid data should be handled
 * using a custom exception.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

// Custom exception
class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

public class P2_DataValidation {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");

            // Check if file exists or not
            // If it does not exist, throw an exception
            if (!inputFile.exists()) {
                throw new FileNotFoundException("The input.txt file does not exist!");
            }

            Scanner sc = new Scanner(inputFile);
            ArrayList<Double> validValues = new ArrayList<>();
            InvalidDataException caughtException = null;

            while (sc.hasNext()) {
                String value = sc.next();

                try {
                    double num = Double.parseDouble(value);
                    validValues.add(num);
                } catch (NumberFormatException e) {
                    caughtException = new InvalidDataException("\"" + value + "\"" + "is not a valid number.");
                }
            }

            sc.close();

            System.out.println("Valid values: " + validValues);

            if (caughtException != null) {
                System.out.println("Exception: InvalidDataException - " + caughtException.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Exception: FileNotFoundException -" + e.getMessage());
        } 
    }
}
