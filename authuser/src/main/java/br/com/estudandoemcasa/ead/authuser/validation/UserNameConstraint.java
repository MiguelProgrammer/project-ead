package br.com.estudandoemcasa.ead.authuser.validation;


import br.com.estudandoemcasa.ead.authuser.validation.impl.UserNameConstraintImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = UserNameConstraintImpl.class)
public @interface UserNameConstraint {

    String message() default "Invalid UserName";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
