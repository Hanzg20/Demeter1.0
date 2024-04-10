/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DAO;
import dataaccesslayer.ItemTypeDaoImpl;
import dataaccesslayer.NotificationDaoImpl;
import dataaccesslayer.SubscriptionDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.ItemTypeDTO;
import model.NotificationDTO;
import model.SubscriptionDTO;
import viewmodel.NotifictionViewModel;
import viewmodel.NotifictionViewModelItem;
import viewmodel.SubscriptionViewModel;
import viewmodel.SubscriptionViewModelItem;

/**
 *
 * @author Glily
 */
public class SubscriptionService {
        private final DAO<ItemTypeDTO> typeDao = new ItemTypeDaoImpl();

    private final SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();
    public SubscriptionViewModel buidSubscriptionViewModel(int userId,String itemType) {
        SubscriptionViewModel viewModel = new SubscriptionViewModel();
        viewModel.setItems(retrieveSubscriptionItemList(userId, itemType));
        return viewModel;
    }
    
    private List<SubscriptionViewModelItem> retrieveSubscriptionItemList(int userId,String itemType) {
        List<SubscriptionDTO> items = subscriptionDao.RetrieveList(userId,itemType);
        List<SubscriptionViewModelItem> result = new ArrayList<>();
        items.forEach(dto -> {
            result.add(SubscriptionViewModelItem.convertFrom(dto,typeDao.Retrieve(dto.getItemTypeId())));

        });
        return result;
    }
}
