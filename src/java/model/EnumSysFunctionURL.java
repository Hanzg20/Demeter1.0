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
public enum EnumSysFunctionURL {
    // Enum constants with their mappings
    USERS(1, "users"),
    INVENTORY(2, "inventory"),
    LISTING(3, "surplus"),
    SALE(4, "sale"),
    DONATION(5, "donation"),
    ORDERS(6, "order"),
    CLAIMS(7, "claim"),
    SUBSCRIPTION(8, "subscription"),
    NOTIFICATION(9, "notification");

    // Fields to store sysFunctionId and sysFunctionUrl
    private final int sysFunctionId;
    private final String sysFunctionUrl;

    // Constructor to initialize sysFunctionId and sysFunctionId
    EnumSysFunctionURL(int sysFunctionId, String url) {
        this.sysFunctionId = sysFunctionId;
        this.sysFunctionUrl = url;
    }
    
    public int getSysFunctionId() {
        return sysFunctionId;
    }

    public String getSysFunctionUrl() {
        return sysFunctionUrl;
    }
    
        // Static method to convert string to EnumItemType
    public static EnumSysFunctionURL fromSysFunctionId(int value) {
        for (EnumSysFunctionURL type : EnumSysFunctionURL.values()) {
            if (type.sysFunctionId == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("No EnumItemType with symbol " + value + " found");
    }
}
