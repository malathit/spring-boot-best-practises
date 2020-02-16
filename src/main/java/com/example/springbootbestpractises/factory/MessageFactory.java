package com.example.springbootbestpractises.factory;

import com.example.springbootbestpractises.constants.MessagingServiceType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageFactory {

  public static Map<String, MessagingService> messagingServiceCache = new HashMap<>();

  public List<MessagingService> messagingServices;

  @PostConstruct
  void initCache() {
    messagingServices.forEach(messagingService -> messagingServiceCache.put(
        messagingService.getType(), messagingService));
  }

  public MessagingService getMessagingService(MessagingServiceType messagingServiceType) {
    if (messagingServiceCache.containsKey(messagingServiceType.getValue())) {
      return messagingServiceCache.get(messagingServiceType.getValue());
    } else {
      String message = "No implementation found for messaging type " + messagingServiceType.getValue();
      System.out.println(message);
      throw new UnsupportedOperationException(message);
    }
  }

}
