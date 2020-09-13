package com.example.springbootbestpractises.dto.request.validations.annotations;

import com.example.springbootbestpractises.dto.request.validations.UniqueUsernameValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Inherited
@Target(value = ElementType.FIELD)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
  /**
   * Default message. 
   */
  String message() default "";

  /**
   * validation group.
   */
  Class<?>[] groups() default {};

  /**
   * Payload if any.
   */
  Class<? extends Payload>[] payload() default {};
}
