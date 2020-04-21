package org.escalade.model.entity.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = UniqueSiteValidator.class)
@Retention(RUNTIME)
public @interface UniqueSite {
    String message();
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
