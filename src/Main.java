public class Main {
    public static void main(String[] args){

        Notification orderNotification = new OrderNotification(new EmailSender());
        orderNotification.sendNotification();

        orderNotification.setSender(new SmsSender());
        orderNotification.sendNotification();

        Notification reminderNotification = new ReminderNotification(new EmailSender());
        reminderNotification.sendNotification();

        reminderNotification.setSender(new SmsSender());
        reminderNotification.sendNotification();
    }
}
