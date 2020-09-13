package com.example.springbootbestpractises.messaging.factory;

public interface MessagingService {
  String getType();
  
  void sendMessage(String message);
}
