package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.Gist

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a Gist is created or updated.
 *
 * https://developer.github.com/v3/activity/events/types/#gistevent
 */
data class GistPayload(
        val action: String,
        val gist: Gist
): Payload() {
    companion object {
        val TYPE_NAME = "GistEvent"
    }
}