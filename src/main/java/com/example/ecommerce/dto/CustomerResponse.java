package com.example.ecommerce.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record CustomerResponse(Long id, String email, String firstName, String LastName) {}
