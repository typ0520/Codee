package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.bean.Milestone
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.bean.Organization

/**
 * Created by tong on 2017/12/26.
 */


/**
 * Triggered when a milestone is created, closed, opened, edited, or deleted.
 * Events of this type are not visible in timelines. These events are only used to trigger hooks.
 *
 * https://developer.github.com/v3/activity/events/types/#milestoneevent
 */
data class MilestonePayload(
		val action: String, //created
		val milestone: Milestone,
		val repository: Repository,
		val organization: Organization,
		val sender: User
): Payload() {
    companion object {
        val TYPE_NAME = "MilestoneEvent"
    }
}

/*
{
  "action":"created",
  "milestone":{
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
  },
  "repository":{
    "id":70275481,
    "name":"public-repo",
    "full_name":"baxterandthehackers/public-repo",
    "owner":{
      "login":"baxterandthehackers",
      "id":4312013,
      "avatar_url":"https://avatars.githubusercontent.com/u/4312013?v=3",
      "gravatar_id":"",
      "url":"https://api.github.com/users/baxterandthehackers",
      "html_url":"https://github.com/baxterandthehackers",
      "followers_url":"https://api.github.com/users/baxterandthehackers/followers",
      "following_url":"https://api.github.com/users/baxterandthehackers/following{/other_user}",
      "gists_url":"https://api.github.com/users/baxterandthehackers/gists{/gist_id}",
      "starred_url":"https://api.github.com/users/baxterandthehackers/starred{/owner}{/repo}",
      "subscriptions_url":"https://api.github.com/users/baxterandthehackers/subscriptions",
      "organizations_url":"https://api.github.com/users/baxterandthehackers/orgs",
      "repos_url":"https://api.github.com/users/baxterandthehackers/repos",
      "events_url":"https://api.github.com/users/baxterandthehackers/events{/privacy}",
      "received_events_url":"https://api.github.com/users/baxterandthehackers/received_events",
      "type":"Organization",
      "site_admin":false
    },
    "private":true,
    "html_url":"https://github.com/baxterandthehackers/public-repo",
    "description":null,
    "fork":false,
    "url":"https://api.github.com/repos/baxterandthehackers/public-repo",
    "forks_url":"https://api.github.com/repos/baxterandthehackers/public-repo/forks",
    "keys_url":"https://api.github.com/repos/baxterandthehackers/public-repo/keys{/key_id}",
    "collaborators_url":"https://api.github.com/repos/baxterandthehackers/public-repo/collaborators{/collaborator}",
    "teams_url":"https://api.github.com/repos/baxterandthehackers/public-repo/teams",
    "hooks_url":"https://api.github.com/repos/baxterandthehackers/public-repo/hooks",
    "issue_events_url":"https://api.github.com/repos/baxterandthehackers/public-repo/issues/events{/number}",
    "events_url":"https://api.github.com/repos/baxterandthehackers/public-repo/events",
    "assignees_url":"https://api.github.com/repos/baxterandthehackers/public-repo/assignees{/user}",
    "branches_url":"https://api.github.com/repos/baxterandthehackers/public-repo/branches{/branch}",
    "tags_url":"https://api.github.com/repos/baxterandthehackers/public-repo/tags",
    "blobs_url":"https://api.github.com/repos/baxterandthehackers/public-repo/git/blobs{/sha}",
    "git_tags_url":"https://api.github.com/repos/baxterandthehackers/public-repo/git/tags{/sha}",
    "git_refs_url":"https://api.github.com/repos/baxterandthehackers/public-repo/git/refs{/sha}",
    "trees_url":"https://api.github.com/repos/baxterandthehackers/public-repo/git/trees{/sha}",
    "statuses_url":"https://api.github.com/repos/baxterandthehackers/public-repo/statuses/{sha}",
    "languages_url":"https://api.github.com/repos/baxterandthehackers/public-repo/languages",
    "stargazers_url":"https://api.github.com/repos/baxterandthehackers/public-repo/stargazers",
    "contributors_url":"https://api.github.com/repos/baxterandthehackers/public-repo/contributors",
    "subscribers_url":"https://api.github.com/repos/baxterandthehackers/public-repo/subscribers",
    "subscription_url":"https://api.github.com/repos/baxterandthehackers/public-repo/subscription",
    "commits_url":"https://api.github.com/repos/baxterandthehackers/public-repo/commits{/sha}",
    "git_commits_url":"https://api.github.com/repos/baxterandthehackers/public-repo/git/commits{/sha}",
    "comments_url":"https://api.github.com/repos/baxterandthehackers/public-repo/comments{/number}",
    "issue_comment_url":"https://api.github.com/repos/baxterandthehackers/public-repo/issues/comments{/number}",
    "contents_url":"https://api.github.com/repos/baxterandthehackers/public-repo/contents/{+path}",
    "compare_url":"https://api.github.com/repos/baxterandthehackers/public-repo/compare/{base}...{head}",
    "merges_url":"https://api.github.com/repos/baxterandthehackers/public-repo/merges",
    "archive_url":"https://api.github.com/repos/baxterandthehackers/public-repo/{archive_format}{/ref}",
    "downloads_url":"https://api.github.com/repos/baxterandthehackers/public-repo/downloads",
    "issues_url":"https://api.github.com/repos/baxterandthehackers/public-repo/issues{/number}",
    "pulls_url":"https://api.github.com/repos/baxterandthehackers/public-repo/pulls{/number}",
    "milestones_url":"https://api.github.com/repos/baxterandthehackers/public-repo/milestones{/number}",
    "notifications_url":"https://api.github.com/repos/baxterandthehackers/public-repo/notifications{?since,all,participating}",
    "labels_url":"https://api.github.com/repos/baxterandthehackers/public-repo/labels{/name}",
    "releases_url":"https://api.github.com/repos/baxterandthehackers/public-repo/releases{/id}",
    "deployments_url":"https://api.github.com/repos/baxterandthehackers/public-repo/deployments",
    "created_at":"2016-10-07T19:10:12Z",
    "updated_at":"2016-10-07T19:10:12Z",
    "pushed_at":"2016-10-07T19:10:13Z",
    "git_url":"git://github.com/baxterandthehackers/public-repo.git",
    "ssh_url":"git@github.com:baxterandthehackers/public-repo.git",
    "clone_url":"https://github.com/baxterandthehackers/public-repo.git",
    "svn_url":"https://github.com/baxterandthehackers/public-repo",
    "homepage":null,
    "size":0,
    "stargazers_count":0,
    "watchers_count":0,
    "language":null,
    "has_issues":true,
    "has_downloads":true,
    "has_wiki":true,
    "has_pages":false,
    "forks_count":0,
    "mirror_url":null,
    "open_issues_count":0,
    "forks":0,
    "open_issues":0,
    "watchers":0,
    "default_branch":"master"
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
  "sender":{
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
  }
}
 */
