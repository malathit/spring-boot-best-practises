package com.example.springbootbestpractises.factory;

public interface MessagingService {
  String getType();
  void sendMessage(String message);
}
