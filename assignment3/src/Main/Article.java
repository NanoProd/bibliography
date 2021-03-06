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

public class Article {
    // attributes
    /**
     * Article digit
     */
    private String digit;
    /**
     * Article author
     */
    private String author;
    /**
     * Article journal
     */
    private String journal;
    /**
     * Article Title
     */
    private String title;
    /**
     * Article year
     */
    private String year;
    /**
     * Article volume
     */
    private String volume;
    /**
     * Article number
     */
    private String number;
    /**
     * Article pages
     */
    private String pages;
    /**
     * Article keywords
     */
    private String keywords;
    /**
     * Article doi
     */
    private String doi;
    /**
     * Article issn
     */
    private String issn;
    /**
     * Article month
     */
    private String month;
    /**
     * Article position
     */
    private int position;

    // constructors
    /**
     * default constructor Values all set to empty strings
     */
    public Article() {
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

    /**
     * sets digit
     * 
     * @param digit String for digit
     */
    // setter methods
    public void setDigit(String digit) {
        if (digit.contains(",")) {
            digit.replace(",", "");
        }
        this.digit = digit;
    }

    /**
     * sets author
     * 
     * @param author String for author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * sets Journal
     * 
     * @param journal String for journal
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * Sets title
     * 
     * @param title String for title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * sets year
     * 
     * @param year String for year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * sets volume
     * 
     * @param volume String for volume
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * sets number
     * 
     * @param number String for number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * sets pages
     * 
     * @param pages String for pages
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * sets keywords
     * 
     * @param keywords String for keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * sets doi
     * 
     * @param doi String for doi
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * sets issn
     * 
     * @param issn String for issn
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     * sets month
     * 
     * @param month String for month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * sets position
     * 
     * @param position int for position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * returns digit
     * 
     * @return String
     */
    // accessor methods
    public String getDigit() {
        return digit;
    }

    /**
     * returns author
     * 
     * @return String
     */
    public String getAuthor() {
        return author;
    }

    /**
     * returns journal
     * 
     * @return String
     */
    public String getJournal() {
        return journal;
    }

    /**
     * returns title
     * 
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns year
     * 
     * @return String
     */
    public String getYear() {
        return year;
    }

    /**
     * returns volume
     * 
     * @return String
     */
    public String getVolume() {
        return volume;
    }

    /**
     * returns number
     * 
     * @return String
     */
    public String getNumber() {
        return number;
    }

    /**
     * returns pages
     * 
     * @return String
     */
    public String getPages() {
        return pages;
    }

    /**
     * returns keywords
     * 
     * @return String
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * returns doi
     * 
     * @return String
     */
    public String getDoi() {
        return doi;
    }

    /**
     * returns issn
     * 
     * @return String
     */
    public String getIssn() {
        return issn;
    }

    /**
     * returns month
     * 
     * @return String
     */
    public String getMonth() {
        return month;
    }

    /**
     * returns position
     * 
     * @return int
     */
    public int getPosition() {
        return position;
    }

    /**
     * returns toString for article object
     * 
     * @return String
     */
    public String toString() {
        return "\nAuthor: " + this.getAuthor() + "\nJournal: " + this.getJournal() + "\nTitle: " + this.getTitle()
                + "\nYear: " + this.getYear() + "\nVolume: " + this.getVolume() + "\nNumber: " + this.getNumber()
                + "\nPages: " + this.getPages() + "\nKeywords: " + this.getKeywords() + "\nDoi: " + this.getDoi()
                + "\nISSN: " + this.getIssn() + "\nMonth: " + this.getMonth() + "\nDigit: " + this.getDigit();
    }

    /**
     * returns author string appropriate for ieee bibliography
     * 
     * @return String
     */
    public String authorsIeee() {
        String temp;
        if (this.author.contains("and")) {
            temp = this.author.replaceAll(" and", ", ");
            temp.concat(".");
        } else {
            temp = "";
        }
        return temp;
    }

    /**
     * returns author string appropriate for acm bibliography
     * 
     * @return String
     */
    public String authorsAcm() {
        int index = 0;
        if (this.author.contains("and")) {
            index = this.author.indexOf("and");
            char[] ch = new char[index];
            for (int i = 0; i < index; i++) {
                ch[i] = this.author.charAt(i);
            }
            String word = new String(ch, 0, index);
            word += "et al. ";
            return word;
        } else {
            return this.author;
        }
    }

    /**
     * returns author string appropriate for NJ bibliography
     * 
     * @return String
     */
    public String authorsNj() {
        String temp;
        if (this.author.contains("and")) {
            temp = this.author.replaceAll("and", "&");
        } else {
            temp = "";
        }
        return temp;
    }

    /**
     * returns full bibliography in IEEE style
     * 
     * @return String
     */
    public String toIeee() {
        return this.authorsIeee() + ". \"" + this.getTitle() + "\"" + ", " + this.getJournal() + ", vol. "
                + this.getVolume() + ", no." + this.getNumber() + ", p." + this.getPages() + ", " + this.getMonth()
                + " " + this.getYear() + ".";
    }

    /**
     * returns full bibliography in ACM style
     * 
     * @return String
     */
    public String toAcm() {
        return "[" + this.getPosition() + "] " + this.authorsAcm() + this.getYear() + ". " + this.getTitle() + ". "
                + this.getJournal() + ". " + this.getVolume() + ", " + this.getNumber() + "(" + this.getYear() + "), "
                + this.getPages() + ". DOI:https://doi.org/" + this.getDoi();
    }

    /**
     * returns full bibliography for NJ style
     * 
     * @return String
     */
    public String toNJ() {
        return this.authorsNj() + ". " + this.getTitle() + ". " + this.getJournal() + ". " + this.getVolume() + ", "
                + this.getPages() + "(" + this.getYear() + ").";
    }

}
