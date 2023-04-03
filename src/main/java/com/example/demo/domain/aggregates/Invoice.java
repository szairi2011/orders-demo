package com.example.demo.domain.aggregates;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "invoices")
public class Invoice {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "order_id")
  private String orderID;

  @Column(name = "total_amount")
  private Integer totalAmount;

  public Invoice(Order order) {
    this.id = UUID.randomUUID().toString();
    this.orderID = order.getId();
    this.totalAmount = calculateTotalAmount(order);
  }

  private int calculateTotalAmount(Order order) {
    // return 100 * order.getOrderItems().size(); // Funky totam amount calculation
    return 152;
  }
}
