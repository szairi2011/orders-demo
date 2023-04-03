package com.example.demo.interfaces.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // Needed by Jackson to perform deserialization of http Rest RequestBody to a CreateOrderDTO object

public class CreateOrderDTO {
  private List<ItemDTO> items;
}
