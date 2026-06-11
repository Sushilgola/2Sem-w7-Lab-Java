
/**
 * Problem 1: Data Processor
 * You are working on a data processing module for a financial analysis tool.
 * The module should read numeric values from a text file, calculate the average
 * of these values, and output the result to another text file.
 * The program should handle file-related issues and invalid data
 * using exception handling.
 */

import java.io.*;
import java.util.Scanner;

public class P1_DataProcessor {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");

            if (!inputFile.exists()) {
                throw new FileNotFoundException("The file input.txt does not exist!");
            }

            Scanner sc = new Scanner(inputFile);

            double sum = 0;
            double count = 0;

            while (sc.hasNext()) {
                String value = sc.next();

                try {
                    double num = Double.parseDouble(value);
                    sum = sum + num;
                    count++;
                } catch (NumberFormatException e) {
                    throw new InvalidDataException("\"" + value + "\" is not a valid number.");
                }
            }

            sc.close();

            if (count == 0) {
                throw new IllegalArgumentException("No numeric value found in the file!");
            }

            double average = sum / count;

            FileWriter writer = new FileWriter("output.txt");
            writer.write(String.valueOf(average));
            writer.close();

            System.out.println("Average written to output.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Exception: FileNotFoundException - " + e.getMessage());
        } catch (InvalidDataException e) {
            System.out.println("Exception: InvalidDataException - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: IllegalArgumentException - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception: IOException - " + e.getMessage());
        }
    }
}
