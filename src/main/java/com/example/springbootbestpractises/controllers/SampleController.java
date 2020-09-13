package com.example.springbootbestpractises.controllers;

import com.example.springbootbestpractises.constants.MessagingServiceType;
import com.example.springbootbestpractises.dto.request.CreateCustomerRequest;
import com.example.springbootbestpractises.messaging.factory.MessageFactory;
import com.example.springbootbestpractises.messaging.factory.MessagingService;
import com.example.springbootbestpractises.models.repositories.CustomerRepository;
import javax.validation.Valid;
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
  private CustomerRepository customerRepository;

  /**
   * Sends message to the input @MessagingServiceType.
   */
  @PostMapping("messaging/{messagingServiceType}")
  public ResponseEntity sendMessage(@RequestBody String message,
      @PathVariable("messagingServiceType") MessagingServiceType messagingServiceType) {
    MessagingService service = messageFactory.getMessagingService(messagingServiceType);
    service.sendMessage(message);
    return new ResponseEntity(HttpStatus.OK);
  }

  /**
   * Creates a new customer in DB.
   */
  @PostMapping("customer")
  public ResponseEntity newCustomer(@RequestBody @Valid CreateCustomerRequest customerDto) {
    com.example.springbootbestpractises.models.Customer customerModel =
        com.example.springbootbestpractises.models.Customer.builder()
        .firstName(customerDto.getFirstName())
        .lastName(customerDto.getLastName())
        .username(customerDto.getUsername())
        .build();
    customerRepository.save(customerModel);
    return new ResponseEntity(HttpStatus.CREATED);
  }
}