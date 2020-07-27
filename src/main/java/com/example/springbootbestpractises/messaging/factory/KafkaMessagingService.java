package com.example.springbootbestpractises.messaging.factory;

import com.example.springbootbestpractises.constants.MessagingServiceType;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessagingService implements MessagingService {
  @Override
  public String getType() {
    return MessagingServiceType.KAFKA.getValue();
  }

  @Override
  public void sendMessage(String message) {
    System.out.println("Sending message via Apache Kafka");
    //Actual code to send message to kafka
  }
}
