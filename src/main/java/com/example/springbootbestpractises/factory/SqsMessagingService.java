package com.example.springbootbestpractises.factory;

import com.example.springbootbestpractises.constants.MessagingServiceType;
import org.springframework.stereotype.Component;

@Component
public class SqsMessagingService implements MessagingService {
  @Override
  public String getType() {
    return MessagingServiceType.SQS.getValue();
  }

  @Override
  public void sendMessage(String message) {
    System.out.println("sending message via AWS SQS");
    //Actual code to write to SQS
  }
}
