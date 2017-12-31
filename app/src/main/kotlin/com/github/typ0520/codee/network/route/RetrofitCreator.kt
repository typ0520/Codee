package com.github.typ0520.codee.network.route

import retrofit2.Retrofit

/**
 * Created by tong on 2017/12/21.
 */
interface RetrofitCreator {
    fun getRetrofit(baseUrl: String): Retrofit
}