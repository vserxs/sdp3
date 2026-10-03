public class OrderNotification extends Notification {
    public OrderNotification(NotificationSender sender) {
        super(sender);
    }
    @Override
    public void sendNotification(){
        sender.send("Your order has been successfully placed");
    }
}
