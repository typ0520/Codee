package com.github.typ0520.codee.network

import com.github.typ0520.codee.CodeeApplication
import com.github.typ0520.codee.network.route.RetrofitCreator
import com.github.typ0520.codee.network.route.RouteRetrofit
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by tong on 2017/12/19.
 */
object RetrofitManager : RetrofitCreator {
    private val client: OkHttpClient  by lazy { createOkHttpClient() }

    val repository: Github by lazy { createRouteRetrofit().create(Github::class.java) }

    private fun createOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val context = CodeeApplication.context
        val cacheFile = File(context.cacheDir, "cache")
        val cache = Cache(cacheFile, 1024 * 1024 * 50)

        return OkHttpClient.Builder()
                .addInterceptor(createHeaderInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .connectTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .writeTimeout(30L, TimeUnit.SECONDS)
                .build()
    }

    private fun createRouteRetrofit(): RouteRetrofit {
        return RouteRetrofit(Github.BASE_URL_API,this)
    }

    private fun createHeaderInterceptor(): Interceptor {
        //TODO add token
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                    //.header("token", token)
                    .method(originalRequest.method(), originalRequest.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    override fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SwissArmyKnifeGsonConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}

