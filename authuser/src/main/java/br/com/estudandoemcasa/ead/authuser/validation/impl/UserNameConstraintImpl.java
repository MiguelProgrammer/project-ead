package br.com.estudandoemcasa.ead.authuser.validation.impl;

import br.com.estudandoemcasa.ead.authuser.validation.UserNameConstraint;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameConstraintImpl implements ConstraintValidator<UserNameConstraint, String> {

    @Override
    public void initialize(UserNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return !ObjectUtils.isEmpty(userName) && !userName.trim().isEmpty() && !userName.contains(" ");
    }
}
