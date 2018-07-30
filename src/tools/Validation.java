/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author iqbael17
 */
public class Validation {
public  boolean isNumber(String input){
    char inpt[] = input.toCharArray();
    for (char c: inpt){
        if((int)c<49 || (int)c>57) return false;
    }
    return true;
}
    
}
