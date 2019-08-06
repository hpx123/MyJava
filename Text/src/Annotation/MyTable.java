package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value =  ElementType.METHOD)//只能写在方法前面
@Retention(RetentionPolicy.RUNTIME)
@Target(value =  ElementType.TYPE)
public @interface MyTable {

    String value();

}
