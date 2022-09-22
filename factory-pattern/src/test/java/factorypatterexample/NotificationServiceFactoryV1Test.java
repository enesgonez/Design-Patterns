package factorypatterexample;

import factorypatternexample.v1.NotificationServiceFactoryV1;
import factorypatternexample.v1.notification.NotificationServiceV1;
import factorypatternexample.v1.notification.impl.MailNotificationServiceImplV1;
import factorypatternexample.v1.notification.impl.SmsNotificationServiceImplV1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NotificationServiceFactoryV1Test {

    private NotificationServiceFactoryV1 notificationServiceFactoryV1;

    @BeforeAll
    void setup() {
        SmsNotificationServiceImplV1 smsNotificationServiceImplV1 = Mockito.mock(SmsNotificationServiceImplV1.class);
        MailNotificationServiceImplV1 mailNotificationServiceImplV1 = Mockito.mock(MailNotificationServiceImplV1.class);
        notificationServiceFactoryV1 = new NotificationServiceFactoryV1(smsNotificationServiceImplV1, mailNotificationServiceImplV1);
    }

    @Test
    void givenSmsType_whenGetNotification_thenReturnsSmsNotificationServiceV1() throws Exception {
        NotificationServiceV1 notificationServiceV1 = notificationServiceFactoryV1.getNotification("sms");
        Assertions.assertTrue(notificationServiceV1 instanceof SmsNotificationServiceImplV1);
    }

    @Test
    void givenMailType_whenGetNotification_thenReturnsMailNotificationServiceV1() throws Exception {
        NotificationServiceV1 notificationServiceV1 = notificationServiceFactoryV1.getNotification("mail");
        Assertions.assertTrue(notificationServiceV1 instanceof MailNotificationServiceImplV1);
    }

    @Test
    void givenUnknownType_whenGetNotification_thenThrowsException() {
        Assertions.assertThrows(Exception.class, () -> notificationServiceFactoryV1.getNotification("push"), "Unknown notification type : push");
    }

}
