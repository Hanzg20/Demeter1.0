/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author liyingguo
 * the values are based on database table
 */
public enum EnumTransactionType {
    // Enum constants with their mappings
    PURCHASE(1, "Purchase"),
    CLAIM(2, "Claim"),//Surplus item
    OTHER(3, "Other");

    // Fields to store value and text
    private final int value;
    private final String text;

    // Constructor to initialize value and text
    EnumTransactionType(int symbol, String text) {
        this.value = symbol;
        this.text = text;
    }
    
    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
    
        // Static method to convert string to EnumItemType
    public static EnumTransactionType fromValue(int value) {
        for (EnumTransactionType type : EnumTransactionType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("No EnumItemType with symbol " + value + " found");
    }
    
    public static EnumTransactionType fromText(String text) {
        for (EnumTransactionType type : EnumTransactionType.values()) {
            if (type.text.equals(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No EnumItemType with symbol " + text + " found");
    }
}
