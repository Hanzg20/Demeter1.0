
package businesslayer;

import dataaccesslayer.SubscriptionDaoImpl;
import java.sql.SQLException;
import java.util.List;
import model.SubscriptionDTO;
import viewmodel.SubsViewModel;

public class SubsService {
    
    private final SubscriptionDaoImpl subsDao = new SubscriptionDaoImpl();
    
    public SubsViewModel buidSubsViewModel() {
        // Retrieve subscriptions from the database
        List<SubscriptionDTO> subscriptions = subsDao.RetrieveAll();
        
        // Create a view model and populate it with subscriptions
        SubsViewModel viewModel = new SubsViewModel(subscriptions);
        
        return viewModel;
    }
    
    public void addSubs(SubscriptionDTO subscription) throws SQLException {
        subsDao.insert(subscription);
    }
        
    /*public SubsViewModel buildSubsAddViewModel() {
        // Create an empty view model for adding subscriptions
        SubsViewModel viewModel = new SubsViewModel();
        
        return viewModel;
    }

    public SubsViewModel buildSubsEditViewModel(int id) {
        // Retrieve the subscription with the given id from the database
        SubscriptionDTO subscription = subsDao.Retrieve(id);
        
        // Create a view model and populate it with the retrieved subscription
        SubsViewModel viewModel = new SubsViewModel(subscription);
        
        return viewModel;
    }
    */
    // Add other methods here
}
