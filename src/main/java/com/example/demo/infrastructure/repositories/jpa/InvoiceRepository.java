package com.example.demo.infrastructure.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.aggregates.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String>{
  
}
