package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */

/*
{
    "url":"https://api.github.com/repos/baxterandthehackers/public-repo/milestones/3",
    "html_url":"https://github.com/baxterandthehackers/public-repo/milestones/Test%20milestone%20creation%20webhook%20from%20command%20line2",
    "labels_url":"https://api.github.com/repos/baxterandthehackers/public-repo/milestones/3/labels",
    "id":2055681,
    "number":3,
    "title":"I am a milestone",
    "description":null,
    "creator":{
      "login":"baxterthehacker",
      "id":7649605,
      "avatar_url":"https://avatars.githubusercontent.com/u/7649605?v=3",
      "gravatar_id":"",
      "url":"https://api.github.com/users/baxterthehacker",
      "html_url":"https://github.com/baxterthehacker",
      "followers_url":"https://api.github.com/users/baxterthehacker/followers",
      "following_url":"https://api.github.com/users/baxterthehacker/following{/other_user}",
      "gists_url":"https://api.github.com/users/baxterthehacker/gists{/gist_id}",
      "starred_url":"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}",
      "subscriptions_url":"https://api.github.com/users/baxterthehacker/subscriptions",
      "organizations_url":"https://api.github.com/users/baxterthehacker/orgs",
      "repos_url":"https://api.github.com/users/baxterthehacker/repos",
      "events_url":"https://api.github.com/users/baxterthehacker/events{/privacy}",
      "received_events_url":"https://api.github.com/users/baxterthehacker/received_events",
      "type":"User",
      "site_admin":true
    },
    "open_issues":0,
    "closed_issues":0,
    "state":"open",
    "created_at":"2016-10-07T19:26:08Z",
    "updated_at":"2016-10-07T19:26:08Z",
    "due_on":null,
    "closed_at":null
}
 */

data class Milestone(
		val url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/milestones/3
		val html_url: String, //https://github.com/baxterandthehackers/public-repo/milestones/Test%20milestone%20creation%20webhook%20from%20command%20line2
		val labels_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/milestones/3/labels
		val id: Int, //2055681
		val number: Int, //3
		val title: String, //I am a milestone
		val description: String?, //null
		val creator: User,
		val open_issues: Int, //0
		val closed_issues: Int, //0
		val state: String, //open
		val created_at: String, //2016-10-07T19:26:08Z
		val updated_at: String, //2016-10-07T19:26:08Z
		val due_on: String?, //null
		val closed_at: String? //null
)