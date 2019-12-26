package com.example.aop.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    String message() default "参数校验不通过，请重新输入";
    long min();
    long max();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
