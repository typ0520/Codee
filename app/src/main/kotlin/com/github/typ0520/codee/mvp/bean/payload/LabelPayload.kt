package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.bean.Organization
import com.github.typ0520.codee.mvp.bean.Label

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a repository's label is created, edited, or deleted.
 * Events of this type are not visible in timelines. These events are only used to trigger hooks.
 *
 * https://developer.github.com/v3/activity/events/types/#labelevent
 */
data class LabelPayload(
		val action: String, //created
		val label: Label,
		val repository: Repository,
		val organization: Organization,
		val sender: User
): Payload() {
    companion object {
        val TYPE_NAME = "LabelEvent"
    }
}

/*
{
  "action":"created",
  "label":{
    "url":"https://api.github.com/repos/baxterandthehackers/public-repo/labels/blocked",
    "name":"blocked",
    "color":"ff0000"
  },
  "repository":{
    "id":67075329,
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
    "created_at":"2016-08-31T21:38:51Z",
    "updated_at":"2016-08-31T21:38:51Z",
    "pushed_at":"2016-08-31T21:38:51Z",
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
    "open_issues_count":2,
    "forks":0,
    "open_issues":2,
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