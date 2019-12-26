package com.example.aop.util;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
    private long max = 1;
    private long min = 1;
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
        System.out.println("my validator init");
    }
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o == null){
            return true;
        }
        if(o.toString().trim().length()>=min && o.toString().trim().length()<=max){
            return true;
        }
        return false;
    }
}
