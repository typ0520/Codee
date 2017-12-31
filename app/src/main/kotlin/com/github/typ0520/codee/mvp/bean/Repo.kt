package com.github.typ0520.codee.mvp.bean

import java.io.Serializable

/**
 * Created by tong on 2017/12/29.
 */
data class Repo(
		val id: Int, //63214860
		val name: String, //typ0520/fastdex
		val url: String //https://api.github.com/repos/typ0520/fastdex
): Serializable {
    val full_name: String
		get() = this.name
}