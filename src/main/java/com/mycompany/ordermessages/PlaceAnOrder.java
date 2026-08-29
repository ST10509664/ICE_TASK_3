/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordermessages;

import java.util.Scanner;

/**
 *
 * @author bibia
 */
public class PlaceAnOrder {
    //arrays
    private static final int[] ITEM_NUMBERS = {111, 222, 333, 444};
    private static final double[] ITEM_PRICES = {0.89, 1.47, 2.43, 5.99};
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        int itemNumber = 0;
        int quantity = 0;
        boolean itemValid = false;
        boolean quantityValid = false;
 
        //get and validate the item number
        while (!itemValid) {
            System.out.print("Enter item number: ");
            String itemInput = input.nextLine();
 
            try {
                itemNumber = validateItemNumber(itemInput);
                itemValid = true;
            } catch (OrderException e) {
                System.out.println(e.getMessage());
            }
        }
 
        //get and validate the item quantity
        while (!quantityValid) {
            System.out.print("Enter quantity: ");
            String quantityInput = input.nextLine();
 
            try {
                quantity = validateQuantity(quantityInput);
                quantityValid = true;
            } catch (OrderException e) {
                System.out.println(e.getMessage());
            }
        }
 
        double price = getPriceForItem(itemNumber);
        double total = price * quantity;
 
        System.out.printf("%nItem Number: %d%n", itemNumber);
        System.out.printf("Quantity: %d%n", quantity);
        System.out.printf("Price per item: $%.2f%n", price);
        System.out.printf("Total amount due: $%.2f%n", total);
 
        input.close();
    }
    
    //validates the item number string
    private static int validateItemNumber(String itemInput) throws OrderException {
        int itemNumber;
 
        try {
            itemNumber = Integer.parseInt(itemInput);
        } catch (NumberFormatException e) {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_NOT_NUMERIC));
        }
 
        if (itemNumber < 0) {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_TOO_LOW));
        }
        if (itemNumber > 9999) {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_TOO_HIGH));
        }
        if (!itemExists(itemNumber)) {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_NOT_FOUND));
        }
 
        return itemNumber;
    }
 

    //validates the quantity string.
    private static int validateQuantity(String quantityInput) throws OrderException {
        int quantity;
 
        try {
            quantity = Integer.parseInt(quantityInput);
        } catch (NumberFormatException e) {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.QTY_NOT_NUMERIC));
        }
 
        if (quantity < 1) {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.QTY_TOO_LOW));
        }
        if (quantity > 12) {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.QTY_TOO_HIGH));
        }
 
        return quantity;
    }
 
    //checks that the item number exists in the inventory
    private static boolean itemExists(int itemNumber) {
        for (int number : ITEM_NUMBERS) {
            if (number == itemNumber) {
                return true;
            }
        }
        return false;
    }
 
    //returns the price for a given item number
    private static double getPriceForItem(int itemNumber) {
        for (int i = 0; i < ITEM_NUMBERS.length; i++) {
            if (ITEM_NUMBERS[i] == itemNumber) {
                return ITEM_PRICES[i];
            }
        }
        return 0.0;
    }
    
}
