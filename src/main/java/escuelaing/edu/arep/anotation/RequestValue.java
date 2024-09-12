package escuelaing.edu.arep.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
public @interface RequestValue {
    String value();
}
