/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordermessages;

/**
 *
 * @author bibia
 */
public class OrderMessages {     
    public static final int ITEM_NOT_NUMERIC   = 0;
    public static final int ITEM_TOO_LOW       = 1;
    public static final int ITEM_TOO_HIGH      = 2;
    public static final int QTY_NOT_NUMERIC    = 3;
    public static final int QTY_TOO_LOW        = 4;
    public static final int QTY_TOO_HIGH       = 5;
    public static final int ITEM_NOT_FOUND     = 6;

    public static final String[] MESSAGES = {
        "Error: Item number must be numeric.",                    
        "Error: Item number is too low (must be 0 or greater).",   
        "Error: Item number is too high (must be 9999 or less).",  
        "Error: Quantity must be numeric.",                       
        "Error: Quantity is too low (must be at least 1).",        
        "Error: Quantity is too high (must be 12 or less).",       
        "Error: Item number does not correspond to a valid item."  
 };

    public static String getMessage(int index) {
        return MESSAGES[index];
    }

}
