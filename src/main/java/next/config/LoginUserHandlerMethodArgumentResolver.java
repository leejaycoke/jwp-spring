package next.config;

import annotation.LoginUser;
import next.controller.UserSessionUtils;
import next.model.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * Created by JuHyunLee on 2017. 5. 8..
 */
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(LoginUser.class) != null;
    }

    @Override
    @Resource
    public User resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Object user = nativeWebRequest.getAttribute(UserSessionUtils.USER_SESSION_KEY, WebRequest.SCOPE_SESSION);
        if (user != null) {
            return (User) user;
        }

        User guestUser = new User();
        guestUser.setGuestUser(true);
        return guestUser;
    }

}
