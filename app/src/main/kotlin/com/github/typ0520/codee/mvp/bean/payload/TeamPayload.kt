package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.Organization
import com.github.typ0520.codee.mvp.bean.Team
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when an organization's team is created or deleted.
 * Events of this type are not visible in timelines. These events are only used to trigger organization hooks.
 *
 * https://developer.github.com/v3/activity/events/types/#teamevent
 */
data class TeamPayload(
		val action: String, //created
		val team: Team,
		val organization: Organization,
		val sender: User
): Payload() {
	companion object {
		val TYPE_NAME = "TeamEvent"
	}
}

/*
{
  "action":"created",
  "team":{
    "name":"team baxter",
    "id":2175394,
    "slug":"team-baxter",
    "description":"",
    "privacy":"secret",
    "url":"https:/api.github.com/teams/2175394",
    "members_url":"https:/api.github.com/teams/2175394/members{/member}",
    "repositories_url":"https:/api.github.com/teams/2175394/repos",
    "permission":"pull"
  },
  "organization":{
    "login":"baxterandthehackers",
    "id":4312013,
    "url":"https://api.github.com/orgs/baxterandthehackers",
    "repos_url":"https://api.github.com/orgs/baxterandthehackers/repos",
    "events_url":"https://api.github.com/orgs/baxterandthehackers/events",
    "hooks_url":"https://api.github.com/orgs/baxterandthehackers/hooks",
    "issues_url":"https://api.github.com/orgs/baxterandthehackers/issues",
    "members_url":"https://api.github.com/orgs/baxterandthehackers/members{/member}",
    "public_members_url":"https://api.github.com/orgs/baxterandthehackers/public_members{/member}",
    "avatar_url":"https://avatars.githubusercontent.com/u/4312013?v=3",
    "description":""
  },
  "sender": {
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
  }
}
 */