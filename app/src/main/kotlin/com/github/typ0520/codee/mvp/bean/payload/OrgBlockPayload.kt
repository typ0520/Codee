package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.Organization
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when an organization blocks or unblocks a user.
 *
 * https://developer.github.com/v3/activity/events/types/#orgblockevent
 */
data class OrgBlockPayload(
		val action: String, //blocked
		val blocked_user: User,
		val organization: Organization,
		val sender: User
): Payload() {
    companion object {
        val TYPE_NAME = "OrgBlockEvent"
    }
}

/*
{
  "action": "blocked",
  "blocked_user": {
    "login": "octocat",
    "id": 583231,
    "avatar_url": "https://avatars.githubusercontent.com/u/583231?v=3",
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
  "organization": {
    "login": "github",
    "id": 4366038,
    "url": "https://api.github.com/orgs/github",
    "repos_url": "https://api.github.com/orgs/github/repos",
    "events_url": "https://api.github.com/orgs/github/events",
    "hooks_url": "https://api.github.com/orgs/github/hooks",
    "issues_url": "https://api.github.com/orgs/github/issues",
    "members_url": "https://api.github.com/orgs/github/members{/member}",
    "public_members_url": "https://api.github.com/orgs/github/public_members{/member}",
    "avatar_url": "https://avatars.githubusercontent.com/u/4366038?v=3",
    "description": ""
  },
  "sender": {
    "login": "octodocs",
    "id": 25781999,
    "avatar_url": "https://avatars.githubusercontent.com/u/25781999?v=3",
    "gravatar_id": "",
    "url": "https://api.github.com/users/octodocs",
    "html_url": "https://github.com/octodocs",
    "followers_url": "https://api.github.com/users/octodocs/followers",
    "following_url": "https://api.github.com/users/octodocs/following{/other_user}",
    "gists_url": "https://api.github.com/users/octodocs/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/octodocs/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/octodocs/subscriptions",
    "organizations_url": "https://api.github.com/users/octodocs/orgs",
    "repos_url": "https://api.github.com/users/octodocs/repos",
    "events_url": "https://api.github.com/users/octodocs/events{/privacy}",
    "received_events_url": "https://api.github.com/users/octodocs/received_events",
    "type": "User",
    "site_admin": false
  }
}
 */