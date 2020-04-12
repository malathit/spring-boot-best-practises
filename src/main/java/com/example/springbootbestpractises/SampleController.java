package com.example.springbootbestpractises;

import com.example.springbootbestpractises.constants.MessagingServiceType;
import com.example.springbootbestpractises.factory.MessageFactory;
import com.example.springbootbestpractises.factory.MessagingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/")
@AllArgsConstructor
public class SampleController {

  private MessageFactory messageFactory;

  @PostMapping("messaging/{messagingServiceType}")
  ResponseEntity sendMessage(@RequestBody String message,
                             @PathVariable("messagingServiceType") MessagingServiceType messagingServiceType) {
    MessagingService service = messageFactory.getMessagingService(messagingServiceType);
    service.sendMessage(message);
    return new ResponseEntity(HttpStatus.OK);
  }
}
