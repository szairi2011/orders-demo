package com.example.demo.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreatedEventData {
  
  private String orderId;
}
