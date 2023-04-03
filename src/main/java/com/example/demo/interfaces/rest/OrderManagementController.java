package com.example.demo.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.commandservices.CreateOrderCommandService;
import com.example.demo.application.commandservices.QueryOrderCommandService;
import com.example.demo.domain.aggregates.Order;
import com.example.demo.interfaces.rest.dto.CreateOrderDTO;
import com.example.demo.interfaces.rest.transform.CreateOrderCommandDTOAssembler;

import lombok.extern.log4j.Log4j;

@Log4j

@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrderManagementController {

  @Autowired
  private CreateOrderCommandService createOrderCommandService;

  @Autowired
  private QueryOrderCommandService queryOrderCommandService;

  @GetMapping
  public List<Order> findAll() {
    return queryOrderCommandService.findAll();
  }

  @PostMapping
  @ResponseBody
  public String createOrder(@RequestBody CreateOrderDTO orderDTO) {
    log.debug("Received a new order to create: " + orderDTO.getItems());
    return this.createOrderCommandService.createOrder(
        CreateOrderCommandDTOAssembler.toCommandFromDto(orderDTO));
  }

  @GetMapping
  @RequestMapping("{product_name}")
  public String getOrder(@RequestParam String product_name) {
    log.debug("Received a new order for product: " + product_name);;
    return "A new order received for product:" + product_name;
  }
}
