/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionPackage;

/**
 *
 * @author unifakhatib
 */
public class EmptyFile extends Exception{

    public EmptyFile() {
        super();
    }

    public EmptyFile(String message) {
        super(message);
    }
}
