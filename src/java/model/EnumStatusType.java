/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author liyingguo
 */
public enum EnumStatusType {
    // Enum constants with their mappings
    AVAILABLE("A", "Available"),
    NARE_EXPIREATION("N", "Near expiration"),//Surplus item
    EXCESS_OF_DEMAND("E", "Excess of demand"),//Surplus item
    LISTED("L", "Listed"),//listed either donate or onSale
    SOLD("S", "Sold");

    // Fields to store symbol and text
    private final String symbol;
    private final String text;

    // Constructor to initialize symbol and text
    EnumStatusType(String symbol, String text) {
        this.symbol = symbol;
        this.text = text;
    }

    // Getter methods
    public String getSymbol() {
        return symbol;
    }

    public String getText() {
        return text;
    }
    
        // Static method to convert string to EnumItemType
    public static EnumStatusType fromSymbol(String symbol) {
        for (EnumStatusType type : EnumStatusType.values()) {
            if (type.symbol.equals(symbol)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No EnumItemType with symbol " + symbol + " found");
    }
    
    public static EnumStatusType fromText(String text) {
        for (EnumStatusType type : EnumStatusType.values()) {
            if (type.text.equals(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No EnumItemType with symbol " + text + " found");
    }
}
