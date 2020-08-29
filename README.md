Pub/sub is an asynchronous messaging serivce that decouples service that produces events from service that processes events.
You can use pub/sub as messaging-oriented middleware or event ingestion and delivery for  streaming analytics pipeline.
Pub sub offers durable message storage and real time message delivery with high availablity and consistent performance at scale.

Core concepts:
1. Topic: A named resource to which messages are sent by publishers.
2. Subscription: A named resource representing the stream of messages from single, specific topic, to be delivered to the subscribing applications.
3. Message: The combination of data and (optional) attributes that a publisher sends to a topic and is eventually deliverd to its subscribers.
4. Message Attribute: A key-value pair that a publisher can define for a message.  For ex key-value pair can be added to messages to mark them as readable by an English speaking subscriber.

Pub/Sub message flows
1. A publisher application creates a topic in the pub/sub service and sends the messages to the topic. A message contains a payload and optional attributes that describe payload content.
2. The service ensures that published messages are retained on behalf of the subscriptions.  A published message is retained for a subscription until it is acknowledged by all subscriber consuming message from the subscription.
3. Pub/sub forwards messages from a topic to all of it's subscrition individually.
4. A subscriber recieves message from either by pub/sub pushing them to subscriber's chosen endpoint, or by subscriber pulling them from the service.
5. The subscriber sends an ACK to pub/sub service for each recieved message.
6. Service removes acknowledged messages from subscription message queue.

Supports many to one and one to many and many to many.

Common Use cases:
1. Balancing workload in network clusters. For ex- large queue of tasks can be efficiently distributed among multiple workers, such as google compute engine instances.
2. Implementing asynchronous workflows. an order processing application can order on a topic, from which it can be processes by one or more workers.