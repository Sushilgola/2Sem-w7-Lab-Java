
/**
 * Problem 4: File Output
 * You need to develop a module for a data reporting tool that writes the
 * calculated average of numeric values to another text file. The module
 * should handle file writing exceptions.
 */

import java.io.FileWriter;
import java.io.IOException;

public class P4_FileOutput {
    public static void main(String[] args) {
        try {
            double average = 30.5;

            FileWriter writer = new FileWriter("result.txt");
            writer.write(String.valueOf(average));

            writer.close();

        } catch (IOException e) {
            System.out.println("Exception: IOException - Could not write to the file result.txt.");
        }
    }
}
