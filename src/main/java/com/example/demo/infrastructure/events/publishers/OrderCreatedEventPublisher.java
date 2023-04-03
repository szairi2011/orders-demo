package com.example.demo.infrastructure.events.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.example.demo.application.commandservices.InvoiceOrderCommandService;
import com.example.demo.domain.events.OrderCreatedEvent;
import com.example.demo.infrastructure.repositories.jpa.OrderRepository;

import lombok.extern.log4j.Log4j;

@Log4j

@Component
public class OrderCreatedEventPublisher {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private InvoiceOrderCommandService invoiceCommandService;

  @TransactionalEventListener
  public void publishOrderCreatedEvent(OrderCreatedEvent event) {
    log.debug("OrderCreatedEvent is raised, and a relatd invoice will be created for order id: " + event.getOrderCreatedEventData().getOrderId());
    orderRepository
      .findByOrderId(event.getOrderCreatedEventData().getOrderId())
      .ifPresent((order) -> {
        log.debug("OrderCreatedEvent is raised, and a relatd invoice will be created ...");
        log.debug("The order items: " + order.getOrderItems());
        invoiceCommandService.createInvoiceForOrder(order);
      });
  }
}
