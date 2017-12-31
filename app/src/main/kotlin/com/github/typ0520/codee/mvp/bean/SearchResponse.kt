package com.github.typ0520.codee.mvp.bean

import java.io.Serializable

/**
 * Created by tong on 2017/12/30.
 */
data class SearchResponse<T> (
		val total_count: Int, //56531
		val incomplete_results: Boolean, //false
		val items: List<T>
): Serializable