//-------------------------------------------------
//Written by: Joshua-James Nantel-Ouimet (#40131733)
//            Samaninder Singh (#40133493)
//COMP 249
//Assignment 3
//Due date: November 13th 2020
//-------------------------------------------------
/**
 * @author Joshua-James Nantel-Ouimet
 * @author Samaninder Singh 
 * @version 1.0
 */
package Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BibliographyFactory {

    // attributes
    /**
     * static int to count all user attempts
     */
    static int userAttempts = 0;
    /**
     * static method that attempts to open all files
     * @param path String pathname for file
     * @return boolean 
     */
    public static boolean attemptToOpenFiles(String path) {
        Scanner inS = null;
        try {
            inS = new Scanner(new FileInputStream(path));
            inS.close();
        } catch (FileNotFoundException e) {
            System.out.print("Could not open input file " + path
                    + " for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.\n");
            System.exit(0);
            return false;

        }
        return true;
    }
    
    
    /**
     * Static method to process all files. If a file is valid, ie has no invalid
     * fields. It will create bibliographies for all articles in the three different
     * styles in three different files for each style
     * 
     * @param array array that holds all files
     */
    public static void processFilesForValidation(FileValidation[] array) {
        for (int i = 1; i <= 10; i++) {
            String ieee = "IEEE" + i + ".json";
            String acm = "ACM" + i + ".json";
            String nj = "NJ" + i + ".json";

            array[i - 1].assignValues();

            if (array[i - 1].getValidFile()) {
                array[i - 1].printIeee(ieee);
                array[i - 1].printAcm(acm);
                array[i - 1].printNj(nj);
            }
        }

        System.out.println(
                "A total of " + FileValidation.invalidF + " files were invalid, and could not be processed. All other "
                        + FileValidation.validF + " \"Valid\" files have been created.\n");
    }

    /**
     * method that asks user which file they would like to review. They have two attempts to enter a valid file name. 
     * If it is valid, program will read the file and output every line to the console
     */
    public static void askUserFile() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the name of one of the files that you need to review:");
        String userFile = keyboard.nextLine();
        userAttempts++;
        BufferedReader inputStream;
        try {
            inputStream = new BufferedReader(new FileReader(userFile));
            System.out.println("Here are the contents of the successfully created Jason File: " + userFile);
            String line;
            boolean valid = true;
            while (valid) {
                line = inputStream.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open input file. File does not exist; possibly it could not be created!");
            if (userAttempts < 2) {
                System.out.println("\n\nHowver, you will be allowed another chance to enter another file name.");
                askUserFile();
            }
            if (userAttempts == 2) {
                System.out.println("That was your final attempt. Program will terminate");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        keyboard.close();
    }

    /**
     * main method
     * @param args[] main method
     */
    public static void main(String args[]) {
        System.out.println("Willkommen in der BiblioThek mit Sam und Josh");
        
        attemptToOpenFiles("Latex1.bib");
        attemptToOpenFiles("Latex2.bib");
        attemptToOpenFiles("Latex3.bib");
        attemptToOpenFiles("Latex4.bib");
        attemptToOpenFiles("Latex5.bib");
        attemptToOpenFiles("Latex6.bib");
        attemptToOpenFiles("Latex7.bib");
        attemptToOpenFiles("Latex8.bib");
        attemptToOpenFiles("Latex9.bib");
        attemptToOpenFiles("Latex10.bib");
        

        FileValidation[] allFiles = new FileValidation[10];

        // use buffered reader to read from text file and get information
        // check how many articles there are in the file
        FileValidation file1 = new FileValidation("Latex1.bib");
        FileValidation file2 = new FileValidation("Latex2.bib");
        FileValidation file3 = new FileValidation("Latex3.bib");
        FileValidation file4 = new FileValidation("Latex4.bib");
        FileValidation file5 = new FileValidation("Latex5.bib");
        FileValidation file6 = new FileValidation("Latex6.bib");
        FileValidation file7 = new FileValidation("Latex7.bib");
        FileValidation file8 = new FileValidation("Latex8.bib");
        FileValidation file9 = new FileValidation("Latex9.bib");
        FileValidation file10 = new FileValidation("Latex10.bib");

        allFiles[0] = file1;
        allFiles[1] = file2;
        allFiles[2] = file3;
        allFiles[3] = file4;
        allFiles[4] = file5;
        allFiles[5] = file6;
        allFiles[6] = file7;
        allFiles[7] = file8;
        allFiles[8] = file9;
        allFiles[9] = file10;

        processFilesForValidation(allFiles);
        askUserFile();

        System.out.println("Goodbye! Hope you have enjoyed creating the needed files using BibliographyFactory.");
    }
}
 