package com.example.demo.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

/* 
 * Notify about and order Scheduled shipping
 */

@Getter
@AllArgsConstructor
public class OrderScheduledEvent {
  private OrderScheduledEventData orderShippedEventData;
}
