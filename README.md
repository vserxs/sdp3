# Notification System using Bridge Pattern

## About the Project

This project is a simple Notification System created in Java using the **Bridge Design Pattern**.

The main idea of the project is to separate two things:

- the type of notification;
- the way the notification is sent.

For example, the system can have an order notification or a reminder notification. At the same time, these notifications can be sent using Email or SMS.

The Bridge Pattern allows these two parts to work independently. This means that I can add a new notification type or a new sending method without changing the existing classes.

---

## Why I Chose This Topic

I chose a Notification System because it is simple to understand and clearly shows how the Bridge Pattern works.

There are two independent parts in the project.

The first part is the notification type:

```text
Notification
├── OrderNotification
└── ReminderNotification

The second part is the delivery method:

NotificationSender
├── EmailSender
└── SmsSender

These two parts are connected using the Bridge Pattern.

Bridge Pattern Structure

The project contains the main components of the Bridge Pattern.

Abstraction

Notification is the main abstract class.

It stores a reference to the NotificationSender interface and defines the common structure for notifications.

Refined Abstraction

There are two refined abstractions:

OrderNotification
ReminderNotification

They extend the Notification class and provide different notification messages.

Implementor

NotificationSender is the Implementor interface.

It contains the common send() method that every sending method must implement.

Concrete Implementors

There are two concrete implementations:

EmailSender
SmsSender

They implement the NotificationSender interface and define how the message is sent.

Client

Main is the Client.

It creates notification objects with different senders and demonstrates changing the implementation at runtime.

Project Structure
NotificationBridge/
│
├── src/
│   ├── NotificationSender.java
│   ├── EmailSender.java
│   ├── SmsSender.java
│   ├── Notification.java
│   ├── OrderNotification.java
│   ├── ReminderNotification.java
│   └── Main.java
│
└── README.md
How the Bridge Works

The most important part of the project is the connection between Notification and NotificationSender.

The Notification class contains:

protected NotificationSender sender;

This means that Notification does not directly depend on EmailSender or SmsSender.

Instead, it depends on the NotificationSender interface.

The structure can be shown like this:

            ABSTRACTION SIDE

              Notification
               /        \
              /          \
OrderNotification   ReminderNotification
              |
              |
              | composition
              ↓
       NotificationSender
          /           \
         /             \
        ↓               ↓
  EmailSender        SmsSender

            IMPLEMENTATION SIDE

The notification side is responsible for the type and content of the notification.

The sender side is responsible for the delivery method.

How the Classes Work
NotificationSender

NotificationSender is an interface.

public interface NotificationSender {

    void send(String message);
}

It defines the common send() operation for different sending methods.

It does not define exactly how the message is sent.

EmailSender

EmailSender implements NotificationSender.

public class EmailSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

For this project, email sending is simulated using System.out.println().

SmsSender

SmsSender is another implementation of NotificationSender.

public class SmsSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

It also simulates sending a message by printing the result to the console.

Notification

Notification is the main abstract class.

public abstract class Notification {

    protected NotificationSender sender;

    protected Notification(NotificationSender sender) {
        this.sender = sender;
    }

    public void setSender(NotificationSender sender) {
        this.sender = sender;
    }

    public abstract void sendNotification();
}

The important part is that Notification stores a reference to NotificationSender.

This creates the bridge between the abstraction and implementation sides.

The setSender() method allows the sending method to be changed while the program is running.

OrderNotification

OrderNotification is a refined abstraction.

public class OrderNotification extends Notification {

    public OrderNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void sendNotification() {
        sender.send("Your order has been successfully placed.");
    }
}

It represents a notification about a successfully placed order.

The class does not need to know whether the message is sent by Email or SMS. It only uses the NotificationSender interface.

ReminderNotification

ReminderNotification is the second refined abstraction.

public class ReminderNotification extends Notification {

    public ReminderNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void sendNotification() {
        sender.send("Reminder: your event is tomorrow.");
    }
}

It works in the same way as OrderNotification, but it contains a different message.

Runtime Switching

One important part of this project is changing the implementation at runtime.

For example:

Notification orderNotification =
        new OrderNotification(new EmailSender());

orderNotification.sendNotification();

orderNotification.setSender(new SmsSender());

orderNotification.sendNotification();

At first, the notification uses EmailSender.

After calling:

orderNotification.setSender(new SmsSender());

the same OrderNotification uses SmsSender.

The OrderNotification class itself does not need to be changed.

This demonstrates that the abstraction and implementation can vary independently.

Example Combinations

Because the notification type and delivery method are separated, they can be combined in different ways.

For example:

OrderNotification + EmailSender
OrderNotification + SmsSender
ReminderNotification + EmailSender
ReminderNotification + SmsSender

Without the Bridge Pattern, I could create separate classes for every combination, such as:

OrderEmailNotification
OrderSmsNotification
ReminderEmailNotification
ReminderSmsNotification

This would make the project larger as more notification types and delivery methods are added.

With the Bridge Pattern, I can reuse the same notification classes with different senders.

Example Output

When the program is executed, the output is:

Sending EMAIL: Your order has been successfully placed.
Sending SMS: Your order has been successfully placed.
Sending EMAIL: Reminder: your event is tomorrow.
Sending SMS: Reminder: your event is tomorrow.

The output shows that the same notification can work with different implementations.
