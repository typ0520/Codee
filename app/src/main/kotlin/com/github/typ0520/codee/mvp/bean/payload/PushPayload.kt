package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.Commit
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017/12/25.
 */

/**
 * Triggered on a push to a repository branch. Branch pushes and repository tag pushes also trigger webhook
 *
 * https://developer.github.com/v3/activity/events/types/#pushevent
 */
data class PushPayload(
        val push_id: Long,
        val size: Int,
        val distinct_size: Int,
		val ref: String, //refs/heads/changes
		val before: String, //9049f1265b7d61be4a8904a9a27120d2064dab3b
		val after: String, //0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c
		val created: Boolean, //false
		val deleted: Boolean, //false
		val forced: Boolean, //false
		val base_ref: Any, //null
		val compare: String, //https://github.com/baxterthehacker/public-repo/compare/9049f1265b7d...0d1a26e67d8f
		val commits: List<Commit>,
		val head_commit:Commit,
		val repository: Repository,
		val pusher: User,
		val sender: User
): Payload() {
    companion object {
        val TYPE_NAME = "PushEvent"
    }
}