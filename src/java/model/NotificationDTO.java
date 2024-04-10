
package model;

import java.sql.Timestamp;

/**
 *
 * @author Glily
 */
public class NotificationDTO {
    private int notiId;
    private int userId;
    private String message;
    private Timestamp timestamp;
    private String status;
    
    public NotificationDTO(int notiId, int userId, String message, Timestamp timestamp, String status) {
    this.notiId = notiId;
    this.userId = userId;
    this.message = message;
    this.timestamp = timestamp;
    this.status = status;
    }

    public NotificationDTO() {
    }
    
    public int getNotiId() {
        return notiId;
    }

    public void setNotiId(int notiId) {
        this.notiId = notiId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
