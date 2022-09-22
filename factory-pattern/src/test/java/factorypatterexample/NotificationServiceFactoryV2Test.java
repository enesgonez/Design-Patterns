package factorypatterexample;

import factorypatternexample.v2.NotificationServiceFactoryV2;
import factorypatternexample.v2.notification.NotificationServiceV2;
import factorypatternexample.v2.notification.impl.MailNotificationServiceImplV2;
import factorypatternexample.v2.notification.impl.PushNotificationServiceImplV2;
import factorypatternexample.v2.notification.impl.SmsNotificationServiceImplV2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NotificationServiceFactoryV2Test {

    private NotificationServiceFactoryV2 notificationServiceFactoryV2;

    @BeforeAll
    void setup() {
        SmsNotificationServiceImplV2 smsNotificationServiceImplV2 = Mockito.mock(SmsNotificationServiceImplV2.class);
        Mockito.when(smsNotificationServiceImplV2.isTypeMatched("sms")).thenReturn(true);
        MailNotificationServiceImplV2 mailNotificationServiceImplV2 = Mockito.mock(MailNotificationServiceImplV2.class);
        Mockito.when(mailNotificationServiceImplV2.isTypeMatched("mail")).thenReturn(true);
        PushNotificationServiceImplV2 pushNotificationServiceImplV2 = Mockito.mock(PushNotificationServiceImplV2.class);
        Mockito.when(pushNotificationServiceImplV2.isTypeMatched("push")).thenReturn(true);
        List<NotificationServiceV2> notificationServiceV2List = new ArrayList<>();
        notificationServiceV2List.add(smsNotificationServiceImplV2);
        notificationServiceV2List.add(mailNotificationServiceImplV2);
        notificationServiceV2List.add(pushNotificationServiceImplV2);
        notificationServiceFactoryV2 = new NotificationServiceFactoryV2(notificationServiceV2List);
    }

    @Test
    void givenSmsType_whenGetNotification_thenReturnsSmsNotificationServiceV2() throws Exception {
        NotificationServiceV2 notificationServiceV2 = notificationServiceFactoryV2.getNotification("sms");
        Assertions.assertTrue(notificationServiceV2 instanceof SmsNotificationServiceImplV2);
    }

    @Test
    void givenMailType_whenGetNotification_thenReturnsMailNotificationServiceV2() throws Exception {
        NotificationServiceV2 notificationServiceV2 = notificationServiceFactoryV2.getNotification("mail");
        Assertions.assertTrue(notificationServiceV2 instanceof MailNotificationServiceImplV2);
    }

    @Test
    void givenPushType_whenGetNotification_thenReturnsPushNotificationServiceV2() throws Exception {
        NotificationServiceV2 notificationServiceV2 = notificationServiceFactoryV2.getNotification("push");
        Assertions.assertTrue(notificationServiceV2 instanceof PushNotificationServiceImplV2);
    }

    @Test
    void givenUnknownType_whenGetNotification_thenThrowsException() {
        Assertions.assertThrows(Exception.class, () -> notificationServiceFactoryV2.getNotification("post"), "Unknown notification type : push");
    }

}
