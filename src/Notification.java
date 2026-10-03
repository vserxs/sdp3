public abstract class Notification {
    protected NotificationSender sender;

    public Notification(NotificationSender sender){
        this.sender = sender;
    }

    public void setSender(NotificationSender sender){
        this.sender = sender;
    }

    public abstract void sendNotification();
}
