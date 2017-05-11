package annotation;

import java.lang.annotation.*;

/**
 * Created by JuHyunLee on 2017. 5. 8..
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {
}
