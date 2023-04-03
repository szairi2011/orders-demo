package com.example.demo.application.commandservices;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.aggregates.Order;
import com.example.demo.domain.commands.CreateOrderCommand;
import com.example.demo.infrastructure.repositories.jpa.OrderRepository;

import lombok.extern.log4j.Log4j;

@Log4j

@Service
public class CreateOrderCommandService {

  @Autowired
  private OrderRepository orderRepository;


  /**
   * @param createOrderCommand
   * @return order Id
   */
  public String createOrder(CreateOrderCommand createOrderCommand) {
    String uuid = UUID.randomUUID().toString();
    createOrderCommand.setId(uuid);
    Order order = new Order(createOrderCommand);
    log.debug("A new order created with ID: " + order.getId());
    // Order order = new Order(); // Using the empty constructor to reduce boiler plate of filling order items from UI ...
    log.debug("Create a new Order instance: " + order);
    order = orderRepository.saveAndFlush(order);
    log.debug("Order ID generated after flushing to DB: " + order.getId());
    return order.getId();
  }

  public void shipOrder(String orderid) {
    this.orderRepository.findById(orderid).ifPresent(
      (order) -> {
        order.scheduleToShip(); // Notify invoice shipping/invoice service about the order status change, i.e. register an OrderScheduledEvent
        orderRepository.saveAndFlush(order);
      }
    );
  }
}
