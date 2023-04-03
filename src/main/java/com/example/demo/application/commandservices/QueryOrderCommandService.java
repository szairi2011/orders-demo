package com.example.demo.application.commandservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.aggregates.Order;
import com.example.demo.infrastructure.repositories.jpa.OrderRepository;

@Service
public class QueryOrderCommandService {
  
  @Autowired
  private OrderRepository orderRepository;

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

}
