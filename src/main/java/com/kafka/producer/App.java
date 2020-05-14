package com.kafka.producer;

import java.time.Instant;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.kafka.producer.exception.KafkaProducerException;

/**
 * Java producer, build and send message to kafka topic
 */
public class App 

{
    public static void main( String[] args ) throws KafkaProducerException
    {
    	 //create kafka producer
        Properties properties = new Properties();
        properties.put (ProducerConfig.CLIENT_ID_CONFIG, "JavaProducerApp");
       
       // properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "sandbox-hdp.hortonworks.com:6667");

        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.ACKS_CONFIG,"1");
        properties.put(ProducerConfig.RETRIES_CONFIG,"3");
        
        Producer<String, String> producer = new KafkaProducer<>(properties);

        //prepare the record
        String recordValue = "Current time is " + Instant.now().toString() +" from java";
        System.out.println("Sending message: " + recordValue);
        ProducerRecord<String, String> record = new ProducerRecord<>("kafka-test", "Ventur", recordValue);

        //produce the record
        producer.send(record);
        producer.flush();

        //close the producer at the end
        producer.close();
    }
}
