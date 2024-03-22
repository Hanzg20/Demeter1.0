
package model;

/**
 *
 * @author Glily
 */
public class TransactionTypeDTO {
    private int tranTypeId;
    private String tranTypeName;

    public TransactionTypeDTO(int tranTypeId, String tranTypeName) {
        this.tranTypeId = tranTypeId;
        this.tranTypeName = tranTypeName;
    }

    public TransactionTypeDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getTranTypeId() {
        return tranTypeId;
    }

    public void setTranTypeId(int tranTypeId) {
        this.tranTypeId = tranTypeId;
    }

    public String getTranTypeName() {
        return tranTypeName;
    }

    public void setTranTypeName(String tranTypeName) {
        this.tranTypeName = tranTypeName;
    }
    
}
