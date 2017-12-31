package com.github.typ0520.codee.mvp.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by tong on 2017/12/26.
 */

//https://developer.github.com/v3/gists/#get-a-single-gist
data class Gist(
		val url: String, //https://api.github.com/gists/aa5a315d61ae9438b18d
		val forks_url: String, //https://api.github.com/gists/aa5a315d61ae9438b18d/forks
		val commits_url: String, //https://api.github.com/gists/aa5a315d61ae9438b18d/commits
		val id: String, //aa5a315d61ae9438b18d
		val description: String, //description of gist
		val public: Boolean, //true
		val owner: User,
		val user: User?, //null
		val files: Files,
		val truncated: Boolean, //false
		val comments: Int, //0
		val comments_url: String, //https://api.github.com/gists/aa5a315d61ae9438b18d/comments/
		val html_url: String, //https://gist.github.com/aa5a315d61ae9438b18d
		val git_pull_url: String, //https://gist.github.com/aa5a315d61ae9438b18d.git
		val git_push_url: String, //https://gist.github.com/aa5a315d61ae9438b18d.git
		val created_at: String, //2010-04-14T02:15:15Z
		val updated_at: String, //2011-06-20T11:34:15Z
		val forks: List<Fork>,
		val history: List<History>
)

data class Fork(
		val user: User,
		val url: String, //https://api.github.com/gists/dee9c42e4998ce2ea439
		val id: String, //dee9c42e4998ce2ea439
		val created_at: String, //2011-04-14T16:00:49Z
		val updated_at: String //2011-04-14T16:00:49Z
)

data class History(
		val url: String, //https://api.github.com/gists/aa5a315d61ae9438b18d/57a7f021a713b1c5a6a199b54cc514735d2d462f
		val version: String, //57a7f021a713b1c5a6a199b54cc514735d2d462f
		val user: User,
		val change_status: ChangeStatus,
		val committed_at: String //2010-04-14T02:15:15Z
)

data class ChangeStatus(
		val deletions: Int, //0
		val additions: Int, //180
		val total: Int //180
)

data class Files(
        @SerializedName("ring.erl")
		val ring_erl: Ringerl
)

data class Ringerl(
		val size: Int, //932
		val raw_url: String, //https://gist.githubusercontent.com/raw/365370/8c4d2d43d178df44f4c03a7f2ac0ff512853564e/ring.erl
		val type: String, //text/plain
		val language: String, //Erlang
		val truncated: Boolean, //false
		val content: String //contents of gist
)