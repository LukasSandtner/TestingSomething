/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */

/**
 *
 * @author Lukas
 */
class MyCustomException extends Exception {
    // Konstruktor s vlastním chybovým hlášením
    public MyCustomException(String message) {
        super(message);
    }
}