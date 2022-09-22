package factorypatternexample.v2.notification.impl;

import factorypatternexample.v2.notification.NotificationServiceV2;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationServiceImplV2 implements NotificationServiceV2 {

    @Override
    public void notifyUser() {
        System.out.println("notify user via push by v2");
    }

    @Override
    public boolean isTypeMatched(String type) {
        return "push".equalsIgnoreCase(type);
    }
    
}
