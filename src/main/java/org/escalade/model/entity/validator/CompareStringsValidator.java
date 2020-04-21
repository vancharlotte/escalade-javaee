package org.escalade.model.entity.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompareStringsValidator implements ConstraintValidator<CompareStrings, String> {

    private String first;
    private String second;


    public void initialize(CompareStrings constraint) {
        this.first = constraint.first();
        this.second = constraint.second();

    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        if (first.equals(second)) {
            return true;
        } else {
            return false;
        }
    }
}

