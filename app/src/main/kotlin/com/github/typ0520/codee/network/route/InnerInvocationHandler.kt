package com.github.typ0520.codee.network.route

import retrofit2.PlatformDelegate
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class InnerInvocationHandler(val routeRetrofit: RouteRetrofit): InvocationHandler {
    override fun invoke(proxy: Any, method: Method, vararg args: Any): Any? {
        if (method.declaringClass == Object::class.java) {
            return method.invoke(proxy, args)
        }
        if (PlatformDelegate.isDefaultMethod(method)) {
            return PlatformDelegate.invokeDefaultMethod(method, method.declaringClass, proxy, args)
        }
        val realService = routeRetrofit.getRealService(proxy, method, args)
        return method.invoke(realService, *args)
    }
}