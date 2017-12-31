package com.github.typ0520.codee.mvp.bean.payload

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a patch is applied in the Fork Queue.
 *
 * https://developer.github.com/v3/activity/events/types/#forkapplyevent
 */
data class ForkApplyPayload(
        val head: String,
        val before: String,
        val after: String
) : Payload() {
    companion object {
        val TYPE_NAME = "ForkApplyEvent"
    }
}