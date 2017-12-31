package com.github.typ0520.codee.mvp.bean

import java.io.Serializable

/**
 * Created by tong on 2017/12/26.
 */
data class Branche(
		val name: String, //master
		val commit: Commit
): Serializable
