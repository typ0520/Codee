package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */
/**
{
    "url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/2",
    "labels_url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/2/labels{/name}",
    "comments_url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/2/comments",
    "events_url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/2/events",
    "html_url": "https://github.com/baxterthehacker/public-repo/issues/2",
    "id": 73464126,
    "number": 2,
    "title": "Spelling error in the README file",
    "user": {
    "login": "baxterthehacker",
    "id": 6752317,
    "avatar_url": "https://avatars.githubusercontent.com/u/6752317?v=3",
    "gravatar_id": "",
    "url": "https://api.github.com/users/baxterthehacker",
    "html_url": "https://github.com/baxterthehacker",
    "followers_url": "https://api.github.com/users/baxterthehacker/followers",
    "following_url": "https://api.github.com/users/baxterthehacker/following{/other_user}",
    "gists_url": "https://api.github.com/users/baxterthehacker/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/baxterthehacker/subscriptions",
    "organizations_url": "https://api.github.com/users/baxterthehacker/orgs",
    "repos_url": "https://api.github.com/users/baxterthehacker/repos",
    "events_url": "https://api.github.com/users/baxterthehacker/events{/privacy}",
    "received_events_url": "https://api.github.com/users/baxterthehacker/received_events",
    "type": "User",
    "site_admin": false
    },
    "labels": [
    {
    "url": "https://api.github.com/repos/baxterthehacker/public-repo/labels/bug",
    "name": "bug",
    "color": "fc2929"
    }
    ],
    "state": "open",
    "locked": false,
    "assignee": null,
    "milestone": null,
    "comments": 1,
    "created_at": "2015-05-05T23:40:28Z",
    "updated_at": "2015-05-05T23:40:28Z",
    "closed_at": null,
    "body": "It looks like you accidently spelled 'commit' with two 't's."
}
 */
data class Issue(
		val id: String, //1
		val url: String, //https://api.github.com/repos/octocat/Hello-World/issues/1347
		val repository_url: String, //https://api.github.com/repos/octocat/Hello-World
		val labels_url: String, //https://api.github.com/repos/octocat/Hello-World/issues/1347/labels{/name}
		val comments_url: String, //https://api.github.com/repos/octocat/Hello-World/issues/1347/comments
		val events_url: String, //https://api.github.com/repos/octocat/Hello-World/issues/1347/events
		val html_url: String, //https://github.com/octocat/Hello-World/issues/1347
		val number: String, //1347
		val state: String, //open
		val title: String, //Found a bug
		val body: String, //I'm having a problem with this.
		val user: User,
		val labels: List<Label>,
		val assignee: User?,
		val assignees: List<User>?,
		val milestone: Milestone,
		val locked: Boolean, //false
		val comments: Int, //0
		val pull_request: PullRequest,
		val closed_at: Any, //null
		val created_at: String, //2011-04-22T13:33:48Z
		val updated_at: String, //2011-04-22T13:33:48Z
		val repository: Repository
)