package pubsub;

import pubsub.publisher.Publisher;
import pubsub.publisher.PublisherImpl;
import pubsub.subscriber.Subscriber;
import pubsub.subscriber.SubscriberImpl;
import pubsub.service.PubSubService;

public class DriverClass {
	public static void main(String[] args) {
		Publisher footballPublisher = new PublisherImpl();
		Publisher cricketPublisher = new PublisherImpl();

		Subscriber footballSubscriber = new SubscriberImpl();
		Subscriber cricketSubscriber = new SubscriberImpl();
		Subscriber allSportsSubscriber = new SubscriberImpl();

		PubSubService pubSubService = new PubSubService();

		Message footballMsg1 = new Message("Football", "Messi plays for Barca");
		Message footballMsg2 = new Message("Football", "Ronaldo plays for Juventus");
		Message footballMsg3 = new Message("Football", "Bayern won Champions League");

		footballPublisher.publish(footballMsg1, pubSubService);
		footballPublisher.publish(footballMsg2, pubSubService);
		footballPublisher.publish(footballMsg3, pubSubService);

		Message cricketMsg1 = new Message("Cricket", "Kohli plays for rcb");
		Message cricketMsg2 = new Message("Cricket", "Dhoni retires");
		Message cricketMsg3 = new Message("Cricket", "IPL in UAE");

		cricketPublisher.publish(cricketMsg1, pubSubService);
		cricketPublisher.publish(cricketMsg2, pubSubService);
		cricketPublisher.publish(cricketMsg3, pubSubService);

		footballSubscriber.addSubscriber("Football", pubSubService);
		cricketSubscriber.addSubscriber("Cricket", pubSubService);
		allSportsSubscriber.addSubscriber("Football", pubSubService);
		allSportsSubscriber.addSubscriber("Cricket", pubSubService);

		pubSubService.broadcast();


		System.out.println("\nMessage for Cricket subscriber: ");
		footballSubscriber.printMessages();

		System.out.println("\nMessage for Football subscriber: ");
		cricketSubscriber.printMessages();

		System.out.println("\nMessage for all sports subscriber: ");
		allSportsSubscriber.printMessages();

	}
}