package factorypatternexample.v2.notification.impl;

import factorypatternexample.v2.notification.NotificationServiceV2;
import org.springframework.stereotype.Component;

@Component
public class MailNotificationServiceImplV2 implements NotificationServiceV2 {
    @Override
    public void notifyUser() {
        System.out.println("notify user via mail by notification v2");
    }

    @Override
    public boolean isTypeMatched(String type) {
        return "mail".equalsIgnoreCase(type);
    }
}
