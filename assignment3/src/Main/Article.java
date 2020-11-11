package Main;

public class Article {
    // attributes
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
    private int position;

    // constructors
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

    // setter methods
    public void setDigit(String digit) {
        if (digit.contains(",")) {
            digit.replace(",", "");
        }
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

    public void setPosition(int position) {
        this.position = position;
    }

    // accessor methods
    public String getDigit() {
        return digit;
    }

    public String getAuthor() {
        return author;
    }

    public String getJournal() {
        return journal;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public String getPages() {
        return pages;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getDoi() {
        return doi;
    }

    public String getIssn() {
        return issn;
    }

    public String getMonth() {
        return month;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        return "\nAuthor: " + this.getAuthor() + "\nJournal: " + this.getJournal() + "\nTitle: " + this.getTitle()
                + "\nYear: " + this.getYear() + "\nVolume: " + this.getVolume() + "\nNumber: " + this.getNumber()
                + "\nPages: " + this.getPages() + "\nKeywords: " + this.getKeywords() + "\nDoi: " + this.getDoi()
                + "\nISSN: " + this.getIssn() + "\nMonth: " + this.getMonth() + "\nDigit: " + this.getDigit();
    }

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

    public String authorsAcm() {
        int index = 0;
        index = this.author.indexOf("and");
        if (index == -1) {
            return this.author;
        }
        char[] ch = new char[index];
        for (int i = 0; i < index; i++) {
            ch[i] = this.author.charAt(i);
        }
        // create string to contain word
        String word = new String(ch, 0, index);

        return word;
    }

    public String authorsNj() {
        String temp;
        if (this.author.contains("and")) {
            temp = this.author.replaceAll("and", "&");
        } else {
            temp = "";
        }
        return temp;
    }

    public String toIeee() {
        return this.authorsIeee() + ". \"" + this.getTitle() + "\"" + ", " + this.getJournal() + ", vol. "
                + this.getVolume() + ", no." + this.getNumber() + ", p." + this.getPages() + ", " + this.getMonth()
                + " " + this.getYear() + ".";
    }

    public String toAcm() {
        return "[" + this.getPosition() + "] " + this.authorsAcm() + "et al. " + this.getYear() + ". " + this.getTitle()
                + ". " + this.getJournal() + ". " + this.getVolume() + ", " + this.getNumber() + "(" + this.getYear()
                + "), " + this.getPages() + ". DOI:https://doi.org/" + this.getDoi();
    }

    public String toNJ() {
      return this.authorsNj() + ". " + this.getTitle() + ". " + this.getJournal() + ". " + this.getVolume() + ", " + this.getPages() + "(" + this.getYear() + ").";
   }

}
