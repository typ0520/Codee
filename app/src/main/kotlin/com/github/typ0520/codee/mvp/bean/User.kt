package com.github.typ0520.codee.mvp.bean

import com.orhanobut.hawk.Hawk

/**
 * Created by tong on 2017/12/22.
 */
//https://api.github.com/users/typ0520
data class User(
		val login: String, //typ0520
		val id: Int, //4417749
		val avatar_url: String, //https://avatars0.githubusercontent.com/u/4417749?v=4
		val gravatar_id: String,
		val url: String, //https://api.github.com/users/typ0520
		val html_url: String, //https://github.com/typ0520
		val followers_url: String, //https://api.github.com/users/typ0520/followers
		val following_url: String, //https://api.github.com/users/typ0520/following{/other_user}
		val gists_url: String, //https://api.github.com/users/typ0520/gists{/gist_id}
		val starred_url: String, //https://api.github.com/users/typ0520/starred{/owner}{/repo}
		val subscriptions_url: String, //https://api.github.com/users/typ0520/subscriptions
		val organizations_url: String, //https://api.github.com/users/typ0520/orgs
		val repos_url: String, //https://api.github.com/users/typ0520/repos
		val events_url: String, //https://api.github.com/users/typ0520/events{/privacy}
		val received_events_url: String, //https://api.github.com/users/typ0520/received_events
		val type: String, //User
		val site_admin: Boolean, //false
		val name: String, //tong
		val company: Any, //null
		val blog: String, //http://www.jianshu.com/u/99c659a8bb36
		val location: Any, //null
		val email: String, //php12345@163.com
		val hireable: Any, //null
		val bio: Any, //null
		val public_repos: Int, //29
		val public_gists: Int, //0
		val followers: Int, //78
		val following: Int, //21
		val created_at: String, //2013-05-13T14:04:18Z
		val updated_at: String, //2017-12-22T02:29:21Z
		val username: String,

		var access_token: String?
) {
    companion object {
        val PREFS_KEY = "user-info"

        fun current(): User? {
            return Hawk.get(PREFS_KEY)
        }
    }

    fun save() {
        Hawk.put(User.PREFS_KEY,this)
    }
}