package Main;

import Exceptions.FileInvalidException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileValidation {
    // attributes
    private int quantityOfArticles;
    private String digit;
    private String author;
    private String journal;
    private String title;
    private String year;
    private String volume;
    private String number;
    private String pages;
    private String keywords;
    private String doi;
    private String issn;
    private String month;

    private String pathFv = "";

    // constructor
    public FileValidation(String pathFv) {
        this.pathFv = pathFv;
    }

    // accessor method
    public String getPathFv() {
        return pathFv;
    }

    // setter methods
    public void setQuantityOfArtricles(int quantityOfArticles) {
        this.quantityOfArticles = quantityOfArticles;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    // Default constructor
    public FileValidation() {
        quantityOfArticles = 0;
        digit = "";
        author = "";
        journal = "";
        title = "";
        year = "";
        volume = "";
        number = "";
        pages = "";
        keywords = "";
        doi = "";
        issn = "";
        month = "";
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
                throw new FileInvalidException();
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
    public void assignValues(){
        try 
        {
            BufferedReader inputStream = new BufferedReader(new FileReader(this.pathFv));
            String line;
            while((line = inputStream.readLine()) != null){
                line = inputStream.readLine();
                if(line.equalsIgnoreCase("@ARTICLE{")){
                    this.quantityOfArticles++;
                   while(!(line.equalsIgnoreCase("}"))){
                       line = inputStream.readLine();
                       if(line.isEmpty()){
                           continue;
                       } else if(line.contains("=")){
                           String field;
                           field =  lookForField(line);
                           String information;
                           information = getInformation(line);
                           switch(field){
                               case "author":
                                   this.setAuthor(information);
                                   break;
                               case "journal":
                                   this.setJournal(information);
                                   break;
                               case "title":
                                   this.setTitle(information);
                                   break;
                               case "year":
                                   this.setYear(information);
                                   break;
                               case "volume":
                                   this.setVolume(information);
                                   break;
                               case "number":
                                   this.setNumber(information);
                                   break;
                               case "pages":
                                   this.setPages(information);
                                   break;
                               case "keywords":
                                   this.setKeywords(information);
                                   break;
                               case "doi":
                                   this.setDoi(information);
                                   break;
                               case "issn":
                                   this.setIssn(information);
                                   break;
                               case "month":
                                   this.setMonth(information);
                                   break;
                               default:
                                   break;
                           }
                       } else {
                           this.setDigit(line);
                       }
                   }
                }

           }



           inputStream.close();
        }
        catch(FileInvalidException e){
            System.out.println(e.toString());
            System.exit(0);
        }
        catch(IOException e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }

    // File validation method

    public void processFilesForValidation() {

    }

}
