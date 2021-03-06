//-------------------------------------------------
//Written by: Joshua-James Nantel-Ouimet (#40131733)
//            Samaninder Singh (#40133493)
//COMP 249
//Assignment 3
//Due date: November 13th 2020
//-------------------------------------------------
package Exceptions;

/**
 * @author Joshua-James Nantel-Ouimet
 * @author Samaninder Singh
 * @version 1.0
 */

public class FileInvalidException extends Exception {
    /*
     * attribute for SerialVersionUID
     */
    //
    private static final long serialVersionUID = 1L;
    private String message;

    /*
     * default constructor
     */
    //
    public FileInvalidException() {
        message = "Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)";
    }

    /*
     * Parametric constructor
     */
    //
    public FileInvalidException(String message) {
        this.message = message;
    }

    /**
     * returns toString for FileInvalidException
     * 
     * @return String
     */
    // toString method
    public String toString() {
        return this.message;
    }

}
