package factorypatternexample.v1.notification.impl;

import factorypatternexample.v1.notification.NotificationServiceV1;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationServiceImplV1 implements NotificationServiceV1 {
    @Override
    public void notifyUser() {
        System.out.println("notify user via sms by notification v1");
    }
}
