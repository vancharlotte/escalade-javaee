package org.escalade.model.entity.validator;

import javax.persistence.Column;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueSiteValidator.class)
@Documented
public @interface UniqueSite
{
    String message() default "nom déjà utilisé";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}