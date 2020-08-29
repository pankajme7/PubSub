package pubsub.service;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import pubsub.Message;
import pubsub.subscriber.Subscriber;

public class PubSubService {

	Map<String, Set<Subscriber>> topicToSubscriber = new HashMap<String, Set<Subscriber>>();

	Queue<Message> messagesQueue = new LinkedList<Message>();

	public void addMessageToQueue(Message message) {
		messagesQueue.add(message);
	}

	public void addSubscriber(String topic, Subscriber subscriber) {
		if(topicToSubscriber.containsKey(topic)) {
			Set<Subscriber> subscribers = topicToSubscriber.get(topic);
			subscribers.add(subscriber);
			topicToSubscriber.put(topic, subscribers);
		} else {
			Set<Subscriber> subscribers = new HashSet<Subscriber>();
			subscribers.add(subscriber);
			topicToSubscriber.put(topic, subscribers);
		}
	}

	public void removeSubscriber(String topic, Subscriber subscriber) {
		if(!topicToSubscriber.containsKey(topic))
			return;
		Set<Subscriber> subscribers = topicToSubscriber.get(topic);
		subscribers.remove(subscriber);
		topicToSubscriber.put(topic, subscribers);
	}

	public void broadcast() {
		while (!messagesQueue.isEmpty()) {
			Message message = messagesQueue.remove();
			String topic = message.getTopic();

			Set<Subscriber> subscribersOfTopic = topicToSubscriber.get(topic);

			for (Subscriber subscriber : subscribersOfTopic) {
				List<Message> subscriberMessage = subscriber.getSubscriberMessages();
				subscriberMessage.add(message);
				subscriber.setSubscriberMessages(subscriberMessage);
			}
		}
	}

}