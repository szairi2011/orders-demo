package com.example.demo.application.commandservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.aggregates.Invoice;
import com.example.demo.domain.aggregates.Order;
import com.example.demo.infrastructure.repositories.jpa.InvoiceRepository;

/* 
 * In a real scenario the Invoice service would be part of a separate bounded context, e.g. invoicems module (for a monolith) or microservice for distributed architecture
 * 
 * The service will be triggered when the order status changes to scheduled for shipment, i.e. when invoking order.ship()
 */

@Service
public class InvoiceOrderCommandService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public String createInvoiceForOrder(Order order) {
    Invoice invoice = new Invoice(order);
    return this.invoiceRepository.saveAndFlush(invoice).getId();
  }
}
