package com.example.demo.interfaces.rest.transform;

import com.example.demo.domain.commands.CreateOrderCommand;
import com.example.demo.interfaces.rest.dto.CreateOrderDTO;

public class CreateOrderCommandDTOAssembler {
  
  public static CreateOrderCommand toCommandFromDto(CreateOrderDTO orderDTO) {

    return new CreateOrderCommand(orderDTO.getItems());
  }
}
