package org.escalade.model.entity.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy= ComparePasswordValidator.class)
@Documented
public @interface ComparePassword {

    String message() default "les mots de passe saisis sont différents";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
