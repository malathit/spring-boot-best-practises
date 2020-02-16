package com.example.springbootbestpractises.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagingServiceType {
  SQS("sqs"),
  KAFKA("kafka");
  private String value;
}
