package com.example.springbootbestpractises.dto.request;

import com.example.springbootbestpractises.dto.request.validations.CustomerChecks;
import com.example.springbootbestpractises.dto.request.validations.annotations.UniqueUsername;
import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@GroupSequence({CreateCustomerRequest.class, CustomerChecks.class})
public class CreateCustomerRequest {

  @Size(min = 2, max = 100, message = "CreateCustomerRequest's first name " 
        + "should be between {min} & {max} characters long")
  @NotBlank(message = "CreateCustomerRequest's first name is required")
  private String firstName;

  @Size(min = 2, max = 100, message = "CreateCustomerRequest's last name " 
        + "should be between {min} & {max} characters long")
  private String lastName;

  @Max(value = 100, message = "CreateCustomerRequest's age' ${validatedValue}' is invalid, "
      + "should be less than {value}")
  @Min(value = 18, message = "CreateCustomerRequest's age '${validatedValue}' is invalid, "
      + "should be greater than {value}")
  private int age;

  @NotNull(message = "Username is required and can't be empty")
  @UniqueUsername(groups = CustomerChecks.class)
  private String username;
}
