package Exceptions;

public class FileInvalidException extends Exception {
    // attribute
    private static final long serialVersionUID = 1L;
    private String message;

    // default constructor
    public FileInvalidException() {
        message = "Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)";
    }

    // Parametric constructor
    public FileInvalidException(String message) {
        this.message = message;
    }

    // toString method
    public String toString() {
        return this.message;
    }

}
