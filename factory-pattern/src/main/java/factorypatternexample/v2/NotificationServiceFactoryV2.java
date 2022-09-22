package factorypatternexample.v2;


import factorypatternexample.v2.notification.NotificationServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationServiceFactoryV2 {

    private final List<NotificationServiceV2> notificationServiceV2List;

    public NotificationServiceV2 getNotification(String type) throws Exception {
        return notificationServiceV2List
                .stream()
                .filter(notificationServiceV2 -> notificationServiceV2.isTypeMatched(type))
                .findFirst()
                .orElseThrow(() -> new Exception("Unknown notification type : " + type));
    }

}
