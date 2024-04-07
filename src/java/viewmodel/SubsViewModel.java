package viewmodel;

import java.util.List;
import model.SubscriptionDTO;

/**
 *
 * @author hanzg
 */
public class SubsViewModel {
    
    private List<SubscriptionDTO> subscriptions;

    public SubsViewModel(List<SubscriptionDTO> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<SubscriptionDTO> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionDTO> subscriptions) {
        this.subscriptions = subscriptions;
    }
    
}
