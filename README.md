# KafkaProducer
Kafka Producer with java. Build and send a message  to Kafka broker  with specific topic.


#Using Hortonworks Sandbox and Kafka 1.1.1

Producer  JAVA:
Create Topic kafka-test:
/usr/hdp/current/kafka-broker/bin/kafka-topics.sh  --create --zookeeper sandbox-hdp.hortonworks.com:2181 --replication-factor 1 --partitions 1 --topic kafka-test

Review Topic list:
/usr/hdp/current/kafka-broker/bin/kafka-topics.sh --zookeeper sandbox-hdp.hortonworks.com:2181 --list

Create Consumer:
/usr/hdp/current/kafka-broker/bin/kafka-console-consumer.sh --bootstrap-server sandbox-hdp.hortonworks.com:6667 --topic kafka-test

Create Producer: (Optional) for this example
/usr/hdp/current/kafka-broker/bin/kafka-console-producer.sh --broker-list sandbox-hdp.hortonworks.com:6667 --topic kafka-test

List Consumer:
/usr/hdp/current/kafka-broker/bin/kafka-consumer-groups.sh  --list --bootstrap-server localhost:6667


Run java application and see consumer console.