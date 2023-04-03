package com.example.demo.domain.commands;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.valueobjects.OrderItem;
import com.example.demo.interfaces.rest.dto.ItemDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderCommand {

  String id;
  private List<OrderItem> items;

  public CreateOrderCommand(List<ItemDTO> items) {
    this.items = toOrderItems(items);
  }

  private List<OrderItem> toOrderItems(List<ItemDTO> items) {

    List<OrderItem> orderItems = new ArrayList<>(items.size());

    for (ItemDTO item : items) {
      orderItems.add(
          new OrderItem(
              item.getProductName(), item.getPrice(), item.getQuantity()));
    }

    return orderItems;
  }

}
