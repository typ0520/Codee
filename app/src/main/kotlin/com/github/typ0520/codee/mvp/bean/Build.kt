package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */
data class Build(
        val url: String, //https://api.github.com/repos/baxterthehacker/public-repo/pages/builds/15995382
        val status: String, //built
        val error: Error,
        val pusher: Pusher,
        val commit: String, //053b99542c83021d6b202d1a1f5ecd5ef7084e55
        val duration: Int, //3790
        val created_at: String, //2015-05-05T23:40:13Z
        val updated_at: String //2015-05-05T23:40:17Z
)

data class Error(
        val message: Any //null
)

data class Pusher(
        val login: String, //baxterthehacker
        val id: Int, //6752317
        val avatar_url: String, //https://avatars.githubusercontent.com/u/6752317?v=3
        val gravatar_id: String,
        val url: String, //https://api.github.com/users/baxterthehacker
        val html_url: String, //https://github.com/baxterthehacker
        val followers_url: String, //https://api.github.com/users/baxterthehacker/followers
        val following_url: String, //https://api.github.com/users/baxterthehacker/following{/other_user}
        val gists_url: String, //https://api.github.com/users/baxterthehacker/gists{/gist_id}
        val starred_url: String, //https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}
        val subscriptions_url: String, //https://api.github.com/users/baxterthehacker/subscriptions
        val organizations_url: String, //https://api.github.com/users/baxterthehacker/orgs
        val repos_url: String, //https://api.github.com/users/baxterthehacker/repos
        val events_url: String, //https://api.github.com/users/baxterthehacker/events{/privacy}
        val received_events_url: String, //https://api.github.com/users/baxterthehacker/received_events
        val type: String, //User
        val site_admin: Boolean //false
)