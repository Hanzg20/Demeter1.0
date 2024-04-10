/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.NotificationDaoImpl;
import dataaccesslayer.TransactionDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;
import model.ItemListingDTO;
import model.NotificationDTO;
import model.SubscriptionDTO;
import model.TransactionDTO;
import viewmodel.ClaimViewModelItem;
import viewmodel.NotifictionViewModel;
import viewmodel.NotifictionViewModelItem;
import viewmodel.SubsViewModel;

/**
 *
 * @author Glily
 */
public class NotifictionService {
    private final NotificationDaoImpl notificationDao = new NotificationDaoImpl();
    public NotifictionViewModel buidNotificationViewModel(int userId,String itemType) {
        NotifictionViewModel viewModel = new NotifictionViewModel();
        viewModel.setItems(retrieveNotifictionItemList(userId,itemType));
        
        return viewModel;
    }
    
    private List<NotifictionViewModelItem> retrieveNotifictionItemList(int userId,String itemType) {
        List<NotificationDTO> items = notificationDao.RetrieveList(userId,itemType);
        List<NotifictionViewModelItem> result = new ArrayList<>();
        items.forEach(transactionDTO -> {
            

        });
        return result;
    }
    
}
