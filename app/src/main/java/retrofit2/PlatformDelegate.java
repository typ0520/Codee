package retrofit2;

import java.lang.reflect.Method;

/**
 * Created by tong on 2017/12/21.
 */
public class PlatformDelegate {
    private static final Platform platform = Platform.get();

    public static boolean isDefaultMethod(Method method) {
        return platform.isDefaultMethod(method);
    }

    public static Object invokeDefaultMethod(Method method, Class<?> declaringClass, Object object, Object... args) throws Throwable {
        return platform.invokeDefaultMethod(method,declaringClass,object,args);
    }
}
