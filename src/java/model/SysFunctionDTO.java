
package model;

/**
 *
 * @author Glily
 */
public class SysFunctionDTO {
    private int funcId;
    private String funcName;

    public SysFunctionDTO(int funcId, String funcName) {
        this.funcId = funcId;
        this.funcName = funcName;
    }

    public SysFunctionDTO() {
    }

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
    
    
}
