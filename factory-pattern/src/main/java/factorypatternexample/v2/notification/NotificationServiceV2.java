package factorypatternexample.v2.notification;

public interface NotificationServiceV2 {

    void notifyUser();

    boolean isTypeMatched(String type);
}
