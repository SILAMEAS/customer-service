package com.example.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerRequest {
  @NotNull(message = "email is required")
  @Email
  private String email;

  @NotNull(message = "firstName is required")
  private String firstName;

  @NotNull(message = "lastName is required")
  private String lastName;
}
