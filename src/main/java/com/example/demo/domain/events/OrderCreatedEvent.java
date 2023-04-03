package com.example.demo.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class OrderCreatedEvent {
  
  private OrderCreatedEventData orderCreatedEventData;

}
