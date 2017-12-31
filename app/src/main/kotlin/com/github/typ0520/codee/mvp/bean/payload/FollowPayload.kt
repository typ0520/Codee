package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a user follows another user.
 *
 * https://developer.github.com/v3/activity/events/types/#followevent
 */
data class FollowPayload(val target: User) : Payload() {
    companion object {
        val TYPE_NAME = "FollowEvent"
    }
}