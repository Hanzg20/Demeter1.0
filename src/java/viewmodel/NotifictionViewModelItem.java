/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.sql.Timestamp;
import model.ItemDTO;
import model.NotificationDTO;
import model.SubscriptionDTO;

/**
 *
 * @author Glily
 */
public class NotifictionViewModelItem {
    private int notiId;
    private int userId;
    private String message;
    private Timestamp timestamp;
    private String status;

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

    
    public static NotifictionViewModelItem convertFrom(NotificationDTO dto)
    {
        NotifictionViewModelItem result = new NotifictionViewModelItem();
        result.setMessage(dto.getMessage());
        result.setNotiId(dto.getNotiId());
        result.setStatus(dto.getStatus());
        result.setTimestamp(dto.getTimestamp());
        return result;
    }
    
}
