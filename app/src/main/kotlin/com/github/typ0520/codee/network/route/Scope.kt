package com.github.typ0520.codee.network.route

/**
 * Created by tong on 2017/12/21.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Scope(val baseUrl: String)