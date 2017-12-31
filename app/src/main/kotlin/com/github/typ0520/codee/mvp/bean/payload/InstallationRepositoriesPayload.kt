package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.bean.Installation
import com.github.typ0520.codee.mvp.bean.Repository

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a repository is added or removed from an installation.
 *
 * https://developer.github.com/v3/activity/events/types/#installationrepositoriesevent
 */
data class InstallationRepositoriesPayload(
		val action: String, //removed
		val installation: Installation,
		val repository_selection: String, //selected
		val repositories_added: List<Repository>,
		val repositories_removed: List<Repository>,
		val sender: User
): Payload() {
    companion object {
        val TYPE_NAME = "InstallationRepositoriesEvent"
    }
}

/*
{
  "action": "removed",
  "installation": {
    "id": 2,
    "account": {
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
    "repository_selection": "selected",
    "access_tokens_url": "https://api.github.com/installations/2/access_tokens",
    "repositories_url": "https://api.github.com/installation/repositories",
    "html_url": "https://github.com/settings/installations/2"
  },
  "repository_selection": "selected",
  "repositories_added": [

  ],
  "repositories_removed": [
    {
      "id": 1296269,
      "name": "Hello-World",
      "full_name": "octocat/Hello-World"
    }
  ],
  "sender": {
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
  }
}
 */