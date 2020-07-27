package com.example.springbootbestpractises.dto.request.validations;

import com.example.springbootbestpractises.dto.request.validations.annotations.UniqueUsername;
import com.example.springbootbestpractises.models.repositories.CustomerRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  private CustomerRepository customerRepository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
    if (customerRepository.findByUsername(username).isPresent()) {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate("Username should be unique. '"
          + username + "' is already taken").addConstraintViolation();
      return false;
    }
    return true;
  }
}
