package ro.teamnet.zth.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by madalin.mocanu on 7/12/2017.
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Table {
    String name() default "";
}
