package com.github.typ0520.codee.route;

import com.github.typ0520.codee.network.route.RouteRetrofit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import retrofit2.PlatformDelegate;

/**
 * Created by tong on 2017/12/21.
 */
public class InnerInvocationHandler implements InvocationHandler {
    private final RouteRetrofit routeRetrofit;

    public InnerInvocationHandler(RouteRetrofit routeRetrofit) {
        this.routeRetrofit = routeRetrofit;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        if (PlatformDelegate.isDefaultMethod(method)) {
            return PlatformDelegate.invokeDefaultMethod(method, method.getDeclaringClass(), proxy, args);
        }
        Object realService = routeRetrofit.getRealService(proxy,method,args);
        return method.invoke(realService,args);
    }
}
