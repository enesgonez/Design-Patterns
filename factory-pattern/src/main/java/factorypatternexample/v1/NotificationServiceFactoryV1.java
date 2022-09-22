package factorypatternexample.v1;


import factorypatternexample.v1.notification.NotificationServiceV1;
import factorypatternexample.v1.notification.impl.MailNotificationServiceImplV1;
import factorypatternexample.v1.notification.impl.SmsNotificationServiceImplV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationServiceFactoryV1 {

    private final SmsNotificationServiceImplV1 smsNotificationServiceImplV1;
    private final MailNotificationServiceImplV1 mailNotificationServiceImplV1;

    public NotificationServiceV1 getNotification(String type) throws Exception {
        if ("sms".equalsIgnoreCase(type)) {
            return smsNotificationServiceImplV1;
        } else if ("mail".equalsIgnoreCase(type)) {
            return mailNotificationServiceImplV1;
        } else {
            throw new Exception("Unknown notification type : " + type);
        }
    }

}
