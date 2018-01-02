package retrofit2

import java.lang.reflect.Method

/**
 * Created by tong on 2018/1/2.
 */
object PlatformDelegate {
    private val platform = Platform.get()

    fun isDefaultMethod(method: Method): Boolean {
        return platform.isDefaultMethod(method)
    }

    @Throws(Throwable::class)
    fun invokeDefaultMethod(method: Method, declaringClass: Class<*>, obj: Any, vararg args: Any): Any? {
        return platform.invokeDefaultMethod(method, declaringClass, obj, *args)
    }
}