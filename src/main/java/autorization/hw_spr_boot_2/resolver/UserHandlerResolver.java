package autorization.hw_spr_boot_2.resolver;

import autorization.hw_spr_boot_2.annotation.LoginUser;
import autorization.hw_spr_boot_2.user.User;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import javax.servlet.http.HttpServletRequest;


@Component
public class UserHandlerResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        User user = new User();

        String query = ((HttpServletRequest) webRequest.getNativeRequest()).getQueryString();
        for(String par : query.split("&")) {
            String name = par.split("=")[0];
            String val = par.split("=")[1];
            if(name.equals("user")) user.setName(val);
            if(name.equals("password")) user.setPass(val);
        }
        return user;
    }
}
