package Main;

import java.util.Scanner;
import java.io.FileNotFoundException;
import Exceptions.*;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ClassHandler {
    // attributes
    private String path;
    private String ieee;
    private String acm;
    private String nj;

    // constructor
    public ClassHandler(String path) {
        this.path = path;
    }

    // accessor method
    public String getPath() {
        return path;
    }

    // create file method
    public void writeToFile() {
        PrintWriter os = null;
        try {
            // attempt to open the file
            os = new PrintWriter(new FileOutputStream(this.getPath()));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file");
        }

        // finish write to file method

        os.close();
    }

    // read from file method
    public boolean processFilesForValidation() {
        Scanner inS = null;
        try {
            inS = new Scanner(new FileInputStream(this.getPath()));
        } catch (FileNotFoundException e) {
            System.out.print("Could not open input file " + this.getPath()
                    + " for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.\n");
            System.exit(0);
            return false;

        }
        return true;
    }

}
