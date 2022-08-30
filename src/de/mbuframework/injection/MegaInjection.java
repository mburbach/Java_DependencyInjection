package de.mbuframework.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation zum Erkennen von Feldern die durch den {@link MegaInjector}
 * initialisiert werden.
 */
@Target( value = ElementType.FIELD )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface MegaInjection
{
    /**
     * Falls Element als singleton deklariert ist, so wird dieses Objekt nur
     * einmal zur Laufzeit instanziert.
     * 
     * @return
     */
    boolean singleton() default true;
}
