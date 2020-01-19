package br.com.arthur.implementacaoh2.entrypoints;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidadorDatas.class)
public @interface ValidaDatas {

    String message() default "Data inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean optional() default false;
    
}