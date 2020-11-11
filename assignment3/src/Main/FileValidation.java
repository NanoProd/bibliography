package Main;

import Exceptions.FileInvalidException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class FileValidation {
    // attributes
    private int quantityOfArticles;
    private Article[] articles;
    private String pathFv = "";
    private boolean isValidFile;
    static String tempField;
    static int invalidF;
    static int validF;


    // constructor
    public FileValidation(String pathFv) {
        this.pathFv = pathFv;
        articles = new Article[20];
        quantityOfArticles = 0;
        isValidFile = false;
    }

    // Default constructor
    public FileValidation() {
        quantityOfArticles = 0;
        articles = new Article[20];
        isValidFile = false;
    }

    // setter method
    public void setQuantityOfArticles(int quantityOfArticles) {
        this.quantityOfArticles = quantityOfArticles;
    }

    // Getter method
    public boolean getValidFile(){
        return isValidFile;
    }
    public Article[] getArticles() {
        return articles;
    }

    public Article getSpecificArticle(int index) {
        return articles[index];
    }

    public String getPathFv() {
        return pathFv;
    }

    public int getQuantityOfArticles() {
        return quantityOfArticles;
    }
    
    // method to find field name
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

    // method to extract text inside of curly brackets
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
            System.out.print("\nError: Detected Empty Field! \n============================\n\nProblem detected with input file: " + this.getPathFv() + 
                            "\nFile is Invalid: Field \"" + tempField + "\" Processing stopped at this point. Other empty fields may be present as well!\n"  );
            
        } catch (IOException e) {
            System.out.println(e.toString());
            
        }
    }

    public String toString() {
        return "\nQuantity of Articles: " + this.getQuantityOfArticles() + "\nFile Path: " + this.getPathFv();
    }

    public void printArticles() {
        for (int i = 0; i < this.quantityOfArticles; i++) {
            System.out.println(this.articles[i].toString());
        }
    }

    public void printIeee(String fileName) {
        PrintWriter os = null;
        try {
            os = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < this.quantityOfArticles; i++) {
                os.println(articles[i].toIeee());
                os.println();
            }
            os.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        catch(IOException e){
            System.out.println(e.toString());
        }

    }

    public void printAcm(String fileName){
        PrintWriter os = null;
        try {
            os = new PrintWriter(new FileWriter(fileName));
            for(int i = 0; i < this.quantityOfArticles; i++){
            os.println(articles[i].toAcm());
            os.println();
            } 
        os.close();
        }
        catch (FileNotFoundException e) {
			System.out.println(e.toString());
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        }

    public void printNj(String fileName){
        PrintWriter os = null;
        try
        {
            os = new PrintWriter(new FileWriter(fileName));
            for(int i = 0; i < this.quantityOfArticles; i++){
            os.println(articles[i].toNJ());
            os.println();
            }
            os.close(); 
        }
        catch(FileNotFoundException e) {
			System.out.println(e.toString());
            }
        catch(IOException e){
            System.out.println(e.toString());
        }
    }

    // File validation method

    public void processFilesForValidation() {

    }

}
