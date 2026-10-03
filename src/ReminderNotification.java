public class ReminderNotification extends Notification {
    public ReminderNotification(NotificationSender sender){
        super(sender);
    }
    @Override
    public void sendNotification(){
        sender.send("Reminder: your event is tomorrow");
    }
}
