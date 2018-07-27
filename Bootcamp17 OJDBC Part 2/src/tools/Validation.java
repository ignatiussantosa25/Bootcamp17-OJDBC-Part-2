/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author Ignatius
 */
public class Validation {

    public boolean isNumber(String input) {
        for (char c : input.toCharArray()) {
            if ((int) c > 46 && (int) c < 59) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isLength(String input, int length){
        return input.length()<= length;
    }
}
