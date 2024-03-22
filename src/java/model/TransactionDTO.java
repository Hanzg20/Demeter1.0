
package model;

/**
 *
 * @author Glily
 */
public class TransactionDTO {
    private int tranId;
    private int tranTypeId;
    private int listingId;
    private int userId;
    private int quantity;
    private long tranDate;

    public TransactionDTO(int tranId, int tranTypeId, int listingId, int userId, int quantity, long tranDate) {
        this.tranId = tranId;
        this.tranTypeId = tranTypeId;
        this.listingId = listingId;
        this.userId = userId;
        this.quantity = quantity;
        this.tranDate = tranDate;
    }

    public TransactionDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getTranId() {
        return tranId;
    }

    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    public int getTranTypeId() {
        return tranTypeId;
    }

    public void setTranTypeId(int tranTypeId) {
        this.tranTypeId = tranTypeId;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTranDate() {
        return tranDate;
    }

    public void setTranDate(long tranDate) {
        this.tranDate = tranDate;
    }
    
    
}
