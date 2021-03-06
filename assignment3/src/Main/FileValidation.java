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

import Exceptions.FileInvalidException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class FileValidation {
    // attributes
    /**
     * Quantity of Articles
     */
    private int quantityOfArticles;
    /**
     * Articles array
     */
    private Article[] articles;
    /**
     * file path
     */
    private String pathFv = "";
    /**
     * File validation boolean
     */
    private boolean isValidFile;
    /**
     * Temp Field
     */
    static String tempField;
    /**
     * Number of Invalid files
     */
    static int invalidF;
    /**
     * Number of Valid files
     */
    static int validF;

    /**
     * Paramterized constructor
     * 
     * @param pathFv file path
     * 
     */
    public FileValidation(String pathFv) {
        this.pathFv = pathFv;
        articles = new Article[20];
        quantityOfArticles = 0;
        isValidFile = false;
    }

    /**
     * Default constructor sets values to zero or false creates array of size 20 to
     * hold articles
     */
    public FileValidation() {
        quantityOfArticles = 0;
        articles = new Article[20];
        isValidFile = false;
    }

    /**
     * sets quantity of articles
     * 
     * @param quantityOfArticles int for quantity of articles
     */
    // setter method
    public void setQuantityOfArticles(int quantityOfArticles) {
        this.quantityOfArticles = quantityOfArticles;
    }

    /**
     * returns true if file is valid
     * 
     * @return boolean
     */
    // Getter method
    public boolean getValidFile() {
        return isValidFile;
    }

    /**
     * returns array of Articles
     * 
     * @return Article[]
     */
    public Article[] getArticles() {
        return articles;
    }

    /**
     * returns specific article asked for by the user
     * 
     * @param index this is the position of the first character of the name of the article
     * @return Article
     */
    public Article getSpecificArticle(int index) {
        return articles[index];
    }

    /**
     * returns the path file
     * 
     * @return String
     */
    public String getPathFv() {
        return pathFv;
    }

    /**
     * returns quanity of articles in a file
     * 
     * @return int
     */
    public int getQuantityOfArticles() {
        return quantityOfArticles;
    }

    /**
     * searches a string object to find out what the field is
     * 
     * @param line String for line that you want to search in
     * @return String
     */
    public static String lookForField(String line) {
        // turn string into char array
        char[] ch = new char[line.length()];
        for (int i = 0; i < line.length(); i++) {
            ch[i] = line.charAt(i);
        }
        // search for equals sign to find the index
        int index = 0;
        for (int j = 0; j < line.length(); j++) {
            if (ch[j] == '=') {
                index = j;
            }
        }

        // create string to contain word
        String word = new String(ch, 0, index);
        return word;
    }

    /**
     * method that looks for information between {} and returns it as a string
     * 
     * @param line string that you want to evaluate
     * @return String
     * @throws FileInvalidException throws if file contains an empty field {}
     */
    public static String getInformation(String line) throws FileInvalidException {
        // turn string into char array
        char[] ch = new char[line.length()];
        for (int i = 0; i < line.length(); i++) {
            ch[i] = line.charAt(i);
        }
        // search for curly brackets
        int indexFirst = 0;
        int indexLast = 0;
        for (int j = 0; j < line.length(); j++) {
            if (ch[j] == '{') {
                indexFirst = j;
            }
            if (ch[j] == '}') {
                indexLast = j;
            }
            if ((indexLast - indexFirst) == 1) {
                throw new FileInvalidException(
                        "Error: input file cannot be parsed due to missing information ( " + tempField + " ) is empty");
            }

        }
        char[] word = new char[indexLast - indexFirst - 1];
        for (int i = 0; i < word.length; i++) {
            word[i] = ch[indexFirst + 1 + i];
        }
        String info = new String(word, 0, word.length);
        return info;
    }

    // assign values from a file
    /**
     * method that prints the bibliographies of all article objects inside a file
     */
    public void assignValues() {
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(this.pathFv));
            String line;
            boolean valid = true;
            while (valid) {
                line = inputStream.readLine();
                if (line == null) {
                    break;
                }
                if (line.contains("ARTICLE")) {
                    Article aObject = new Article();
                    aObject.setPosition(this.quantityOfArticles + 1);
                    this.articles[this.quantityOfArticles] = aObject;
                    while (!(line.equalsIgnoreCase("}"))) {
                        line = inputStream.readLine();
                        if (line.isEmpty()) {
                            continue;
                        } else if (line.contains("=")) {
                            String field;
                            field = lookForField(line);
                            tempField = field;
                            String information;
                            information = getInformation(line);
                            switch (field) {
                                case "author":
                                    articles[this.quantityOfArticles].setAuthor(information);
                                    break;
                                case "journal":
                                    articles[this.quantityOfArticles].setJournal(information);
                                    break;
                                case "title":
                                    articles[this.quantityOfArticles].setTitle(information);
                                    break;
                                case "year":
                                    articles[this.quantityOfArticles].setYear(information);
                                    break;
                                case "volume":
                                    articles[this.quantityOfArticles].setVolume(information);
                                    break;
                                case "number":
                                    articles[this.quantityOfArticles].setNumber(information);
                                    break;
                                case "pages":
                                    articles[this.quantityOfArticles].setPages(information);
                                    break;
                                case "keywords":
                                    articles[this.quantityOfArticles].setKeywords(information);
                                    break;
                                case "doi":
                                    articles[this.quantityOfArticles].setDoi(information);
                                    break;
                                case "ISSN":
                                    articles[this.quantityOfArticles].setIssn(information);
                                    break;
                                case "month":
                                    articles[this.quantityOfArticles].setMonth(information);
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            if (line.contains("}")) {
                                continue;
                            }
                            articles[this.quantityOfArticles].setDigit(line);
                        }
                    }
                    this.quantityOfArticles++;

                }

            }
            inputStream.close();
            validF++;
            this.isValidFile = true;

        } catch (FileInvalidException e) {
            invalidF++;
            System.out.print(
                    "\nError: Detected Empty Field! \n============================\n\nProblem detected with input file: "
                            + this.getPathFv() + "\nFile is Invalid: Field \"" + tempField
                            + "\" Processing stopped at this point. Other empty fields may be present as well!\n");

        } catch (IOException e) {
            System.out.println(e.toString());

        }
    }

    /**
     * returns a toString method that gives the quantity of articles + the file path
     * 
     * @return String
     */
    public String toString() {
        return "\nQuantity of Articles: " + this.getQuantityOfArticles() + "\nFile Path: " + this.getPathFv();
    }

    public void printArticles() {
        for (int i = 0; i < this.quantityOfArticles; i++) {
            System.out.println(this.articles[i].toString());
        }
    }

    /**
     * prints out bibliogrpahyin the ieee style to fa ile
     * 
     * @param fileName name of the file
     */
    public void printIeee(String fileName) {
        PrintWriter os = null;
        try {
            os = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < this.quantityOfArticles; i++) {
                os.println(articles[i].toIeee());
                os.println();
            }
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    /**
     * prints out a bibliography in the acm style to a file
     * 
     * @param fileName String for name of the file path
     */
    public void printAcm(String fileName) {
        PrintWriter os = null;
        try {
            os = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < this.quantityOfArticles; i++) {
                os.println(articles[i].toAcm());
                os.println();
            }
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * prints out a bibliography in NJ style to a file
     * 
     * @param fileName String for name of the file path
     */
    public void printNj(String fileName) {
        PrintWriter os = null;
        try {
            os = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < this.quantityOfArticles; i++) {
                os.println(articles[i].toNJ());
                os.println();
            }
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
