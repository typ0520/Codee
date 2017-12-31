package com.github.typ0520.codee.network.route

import com.github.typ0520.codee.network.Github
import com.github.typ0520.codee.route.InnerInvocationHandler
import retrofit2.Retrofit
import java.lang.Class
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * Created by tong on 2017/12/21.
 */
open class RouteRetrofit(val defaultBaseUrl: String? = "", val creator: RetrofitCreator) : RetrofitCreator {
    val retrofitCacheMap: MutableMap<String,Retrofit> = mutableMapOf()
    val serviceCacheMap: MutableMap<String,Any> = mutableMapOf()

    fun <T> create(service: Class<T>): T {
        return Proxy.newProxyInstance(service.classLoader, arrayOf(Github::class.java), InnerInvocationHandler(this)) as T
    }

    fun getRealService(proxy: Any, method: Method, args: Array<out Any>?): Any {
        val score: Scope? = method.getAnnotation(Scope::class.java)
        val baseUrl = (score?.baseUrl ?: defaultBaseUrl) ?: throw IllegalStateException("Can not find baseurl when invoke method: $method")

        var realService: Any? = serviceCacheMap.get(baseUrl)
        if (realService == null) {
            val retrofit = getRetrofit(baseUrl)
            realService = retrofit.create(method.declaringClass)
            serviceCacheMap.put(baseUrl,realService!!)
        }
        return realService
    }

    override fun getRetrofit(baseUrl: String): Retrofit {
        var retrofit = retrofitCacheMap.get(baseUrl)
        if (retrofit == null) {
            retrofit = creator.getRetrofit(baseUrl)
            retrofitCacheMap.put(baseUrl, retrofit)
        }
        return retrofit
    }
}
