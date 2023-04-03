package com.example.demo.domain.valueobjects;

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

@Entity
public class OrderItem {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "product_name")
  private String productName;

  private Double price;

  private Integer quantity;

  public OrderItem(String productName) {
    this.productName = productName;
  }

  public OrderItem(String productName, double price, int quantity) {
    this.id = UUID.randomUUID().toString();
    this.productName = productName;
    this.price = price;
    this.quantity = quantity;
  }

}
