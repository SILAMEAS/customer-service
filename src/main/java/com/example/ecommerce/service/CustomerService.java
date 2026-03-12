package com.example.ecommerce.service;

import com.example.ecommerce.dto.CustomerRequest;
import com.example.ecommerce.dto.CustomerResponse;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.repository.CustomerRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Transactional(readOnly = true)
  public List<CustomerResponse> list() {
    return this.customerRepository.findAll().stream()
        .map(
            cm ->
                CustomerResponse.builder()
                    .id(cm.getId())
                    .firstName(cm.getFirstName())
                    .LastName(cm.getLastName())
                    .build())
        .toList();
  }

  @Transactional
  public CustomerResponse create(CustomerRequest customerRequest) {
    Customer customer =
        Customer.builder()
            .email(customerRequest.getEmail())
            .firstName(customerRequest.getFirstName())
            .lastName(customerRequest.getLastName())
            .addresses(null)
            .build();

    this.customerRepository.save(customer);

    return CustomerResponse.builder()
        .id(customer.getId())
        .email(customer.getEmail())
        .firstName(customer.getFirstName())
        .LastName(customer.getLastName())
        .build();
  }
}
