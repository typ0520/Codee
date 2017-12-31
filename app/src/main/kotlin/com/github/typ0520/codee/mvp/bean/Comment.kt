package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */

/*
{
    "id": 1,
    "url": "https://api.github.com/repos/octocat/Hello-World/issues/comments/1",
    "html_url": "https://github.com/octocat/Hello-World/issues/1347#issuecomment-1",
    "body": "Me too",
    "user": {
      "login": "octocat",
      "id": 1,
      "avatar_url": "https://github.com/images/error/octocat_happy.gif",
      "gravatar_id": "",
      "url": "https://api.github.com/users/octocat",
      "html_url": "https://github.com/octocat",
      "followers_url": "https://api.github.com/users/octocat/followers",
      "following_url": "https://api.github.com/users/octocat/following{/other_user}",
      "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
      "organizations_url": "https://api.github.com/users/octocat/orgs",
      "repos_url": "https://api.github.com/users/octocat/repos",
      "events_url": "https://api.github.com/users/octocat/events{/privacy}",
      "received_events_url": "https://api.github.com/users/octocat/received_events",
      "type": "User",
      "site_admin": false
    },
    "created_at": "2011-04-14T16:00:49Z",
    "updated_at": "2011-04-14T16:00:49Z"
 }
 */
data class Comment(
		val id: Int, //1
		val url: String, //https://api.github.com/repos/octocat/Hello-World/issues/comments/1
		val html_url: String, //https://github.com/octocat/Hello-World/issues/1347#issuecomment-1
		val body: String, //Me too
		val commit_id: String,
		val user: User,
		val created_at: String, //2011-04-14T16:00:49Z
		val updated_at: String //2011-04-14T16:00:49Z
)