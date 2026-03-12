package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CustomerRequest;
import com.example.ecommerce.dto.CustomerResponse;
import com.example.ecommerce.service.CustomerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${application.config.version}/customer")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  ResponseEntity<CustomerResponse> createCustomer(
      @RequestBody @Validated CustomerRequest customerRequest) {
    return new ResponseEntity<>(this.customerService.create(customerRequest), HttpStatus.OK);
  }

  @GetMapping
  ResponseEntity<List<CustomerResponse>> listAllCustomer() {
    return new ResponseEntity<>(this.customerService.list(), HttpStatus.OK);
  }
}
