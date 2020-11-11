package Main;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import Exceptions.FileInvalidException;
import java.io.File;
import java.io.FileNotFoundException;





public class BibliographyFactory {

    //attributes
    static int userAttempts = 0;

    public static void processFilesForValidation(FileValidation[] array){
        for(int i = 1; i <=10; i++){
            String ieee = "IEEE" + i + ".json";
            String acm = "ACM" + i + ".json";
            String nj = "NJ" + i + ".json";

            array[i-1].assignValues();

            if(array[i-1].getValidFile()){
                array[i-1].printIeee(ieee);
                array[i-1].printAcm(acm);
                array[i-1].printNj(nj);
            }
        }

        System.out.println("A total of " + FileValidation.invalidF + " files were invalid, and could not be processed. All other " + FileValidation.validF + " \"Valid\" files have been created.\n");
    }

    public static void askUserFile(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the name of one of the files that you need to review:");
        String userFile = keyboard.nextLine();
        userAttempts++;
        BufferedReader inputStream;
        try
        {
            inputStream = new BufferedReader(new FileReader(userFile));
            System.out.println("Here are the contents of the successfully created Jason File: " + userFile);
            String line;
            boolean valid = true;
            while(valid){
                line = inputStream.readLine();
                if(line == null)
                    break;
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not open input file. File does not exist; possibly it could not be created!");
            if(userAttempts < 2){
                System.out.println("\n\nHowver, you will be allowed another chance to enter another file name.");
                askUserFile();
            }
            if(userAttempts == 2){
                System.out.println("That was your final attempt. Program will terminate");
                System.exit(0);
            }
        }
        catch(IOException e ){
            System.out.println(e.toString());
        }

        
  
    }

    public static void main(String args[]) {

        System.out.println("Willkommen in der BiblioThek");

        // attempt to open all 10 input files
        // if one file cannot be opened, will terminate the program
      //  ClassHandler[] allFiles = new ClassHandler[10];
        ClassHandler latex1 = new ClassHandler("Latex1.bib");
        ClassHandler latex2 = new ClassHandler("Latex2.bib");
        ClassHandler latex3 = new ClassHandler("Latex3.bib");
        ClassHandler latex4 = new ClassHandler("Latex4.bib");
        ClassHandler latex5 = new ClassHandler("Latex5.bib");
        ClassHandler latex6 = new ClassHandler("Latex6.bib");
        ClassHandler latex7 = new ClassHandler("Latex7.bib");
        ClassHandler latex8 = new ClassHandler("Latex8.bib");
        ClassHandler latex9 = new ClassHandler("Latex9.bib");
        ClassHandler latex10 = new ClassHandler("Latex10.bib");
  


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
