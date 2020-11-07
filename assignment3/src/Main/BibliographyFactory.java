package Main;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

import Exceptions.FileInvalidException;

public class BibliographyFactory {

    public static void main(String args[]) {

        System.out.println("Willkommen in der BiblioThek");

        // attempt to open all 10 input files
        // if one file cannot be opened, will terminate the program
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

        System.out.println(latex1.tryToOpenFile());
        System.out.println(latex2.tryToOpenFile());
        System.out.println(latex3.tryToOpenFile());
        System.out.println(latex4.tryToOpenFile());
        System.out.println(latex5.tryToOpenFile());
        System.out.println(latex6.tryToOpenFile());
        System.out.println(latex7.tryToOpenFile());
        System.out.println(latex8.tryToOpenFile());
        System.out.println(latex9.tryToOpenFile());
        System.out.println(latex10.tryToOpenFile());

        // use buffered reader to read from text file and get information
        // check how many articles there are in the file
        FileValidation test = new FileValidation("Latex1.bib");
        test.assignValues();

        System.out.println("");


    }
}
