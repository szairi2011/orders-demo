package com.example.demo.infrastructure.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.aggregates.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

  public Optional<Order> findByOrderId(String orderId); // using @NamedQuery for custom SQL queries

}
