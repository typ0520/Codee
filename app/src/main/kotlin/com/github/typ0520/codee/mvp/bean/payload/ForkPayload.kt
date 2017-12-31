package com.github.typ0520.codee.mvp.bean.payload

import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a user forks a repository.
 *
 * https://developer.github.com/v3/activity/events/types/#followevent
 */
data class ForkPayload(
		val forkee: Forkee,
		val repository: Repository,
		val sender: User
): Payload() {
    companion object {
        val TYPE_NAME = "ForkEvent"
    }
}

data class Forkee(
		val id: Int, //35129393
		val name: String, //public-repo
		val full_name: String, //baxterandthehackers/public-repo
		val owner: User,
		val private: Boolean, //false
		val html_url: String, //https://github.com/baxterandthehackers/public-repo
		val description: String,
		val fork: Boolean, //true
		val url: String, //https://api.github.com/repos/baxterandthehackers/public-repo
		val forks_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/forks
		val keys_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/keys{/key_id}
		val collaborators_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/collaborators{/collaborator}
		val teams_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/teams
		val hooks_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/hooks
		val issue_events_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/issues/events{/number}
		val events_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/events
		val assignees_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/assignees{/user}
		val branches_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/branches{/branch}
		val tags_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/tags
		val blobs_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/git/blobs{/sha}
		val git_tags_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/git/tags{/sha}
		val git_refs_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/git/refs{/sha}
		val trees_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/git/trees{/sha}
		val statuses_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/statuses/{sha}
		val languages_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/languages
		val stargazers_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/stargazers
		val contributors_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/contributors
		val subscribers_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/subscribers
		val subscription_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/subscription
		val commits_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/commits{/sha}
		val git_commits_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/git/commits{/sha}
		val comments_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/comments{/number}
		val issue_comment_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/issues/comments{/number}
		val contents_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/contents/{+path}
		val compare_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/compare/{base}...{head}
		val merges_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/merges
		val archive_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/{archive_format}{/ref}
		val downloads_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/downloads
		val issues_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/issues{/number}
		val pulls_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/pulls{/number}
		val milestones_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/milestones{/number}
		val notifications_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/notifications{?since,all,participating}
		val labels_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/labels{/name}
		val releases_url: String, //https://api.github.com/repos/baxterandthehackers/public-repo/releases{/id}
		val created_at: String, //2015-05-05T23:40:30Z
		val updated_at: String, //2015-05-05T23:40:30Z
		val pushed_at: String, //2015-05-05T23:40:27Z
		val git_url: String, //git://github.com/baxterandthehackers/public-repo.git
		val ssh_url: String, //git@github.com:baxterandthehackers/public-repo.git
		val clone_url: String, //https://github.com/baxterandthehackers/public-repo.git
		val svn_url: String, //https://github.com/baxterandthehackers/public-repo
		val homepage: Any, //null
		val size: Int, //0
		val stargazers_count: Int, //0
		val watchers_count: Int, //0
		val language: Any, //null
		val has_issues: Boolean, //false
		val has_downloads: Boolean, //true
		val has_wiki: Boolean, //true
		val has_pages: Boolean, //true
		val forks_count: Int, //0
		val mirror_url: Any, //null
		val open_issues_count: Int, //0
		val forks: Int, //0
		val open_issues: Int, //0
		val watchers: Int, //0
		val default_branch: String, //master
		val public: Boolean //true
)

/*
{
  "forkee": {
    "id": 35129393,
    "name": "public-repo",
    "full_name": "baxterandthehackers/public-repo",
    "owner": {
      "login": "baxterandthehackers",
      "id": 7649605,
      "avatar_url": "https://avatars.githubusercontent.com/u/7649605?v=3",
      "gravatar_id": "",
      "url": "https://api.github.com/users/baxterandthehackers",
      "html_url": "https://github.com/baxterandthehackers",
      "followers_url": "https://api.github.com/users/baxterandthehackers/followers",
      "following_url": "https://api.github.com/users/baxterandthehackers/following{/other_user}",
      "gists_url": "https://api.github.com/users/baxterandthehackers/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/baxterandthehackers/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/baxterandthehackers/subscriptions",
      "organizations_url": "https://api.github.com/users/baxterandthehackers/orgs",
      "repos_url": "https://api.github.com/users/baxterandthehackers/repos",
      "events_url": "https://api.github.com/users/baxterandthehackers/events{/privacy}",
      "received_events_url": "https://api.github.com/users/baxterandthehackers/received_events",
      "type": "Organization",
      "site_admin": false
    },
    "private": false,
    "html_url": "https://github.com/baxterandthehackers/public-repo",
    "description": "",
    "fork": true,
    "url": "https://api.github.com/repos/baxterandthehackers/public-repo",
    "forks_url": "https://api.github.com/repos/baxterandthehackers/public-repo/forks",
    "keys_url": "https://api.github.com/repos/baxterandthehackers/public-repo/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/baxterandthehackers/public-repo/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/baxterandthehackers/public-repo/teams",
    "hooks_url": "https://api.github.com/repos/baxterandthehackers/public-repo/hooks",
    "issue_events_url": "https://api.github.com/repos/baxterandthehackers/public-repo/issues/events{/number}",
    "events_url": "https://api.github.com/repos/baxterandthehackers/public-repo/events",
    "assignees_url": "https://api.github.com/repos/baxterandthehackers/public-repo/assignees{/user}",
    "branches_url": "https://api.github.com/repos/baxterandthehackers/public-repo/branches{/branch}",
    "tags_url": "https://api.github.com/repos/baxterandthehackers/public-repo/tags",
    "blobs_url": "https://api.github.com/repos/baxterandthehackers/public-repo/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/baxterandthehackers/public-repo/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/baxterandthehackers/public-repo/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/baxterandthehackers/public-repo/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/baxterandthehackers/public-repo/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/baxterandthehackers/public-repo/languages",
    "stargazers_url": "https://api.github.com/repos/baxterandthehackers/public-repo/stargazers",
    "contributors_url": "https://api.github.com/repos/baxterandthehackers/public-repo/contributors",
    "subscribers_url": "https://api.github.com/repos/baxterandthehackers/public-repo/subscribers",
    "subscription_url": "https://api.github.com/repos/baxterandthehackers/public-repo/subscription",
    "commits_url": "https://api.github.com/repos/baxterandthehackers/public-repo/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/baxterandthehackers/public-repo/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/baxterandthehackers/public-repo/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/baxterandthehackers/public-repo/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/baxterandthehackers/public-repo/contents/{+path}",
    "compare_url": "https://api.github.com/repos/baxterandthehackers/public-repo/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/baxterandthehackers/public-repo/merges",
    "archive_url": "https://api.github.com/repos/baxterandthehackers/public-repo/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/baxterandthehackers/public-repo/downloads",
    "issues_url": "https://api.github.com/repos/baxterandthehackers/public-repo/issues{/number}",
    "pulls_url": "https://api.github.com/repos/baxterandthehackers/public-repo/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/baxterandthehackers/public-repo/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/baxterandthehackers/public-repo/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/baxterandthehackers/public-repo/labels{/name}",
    "releases_url": "https://api.github.com/repos/baxterandthehackers/public-repo/releases{/id}",
    "created_at": "2015-05-05T23:40:30Z",
    "updated_at": "2015-05-05T23:40:30Z",
    "pushed_at": "2015-05-05T23:40:27Z",
    "git_url": "git://github.com/baxterandthehackers/public-repo.git",
    "ssh_url": "git@github.com:baxterandthehackers/public-repo.git",
    "clone_url": "https://github.com/baxterandthehackers/public-repo.git",
    "svn_url": "https://github.com/baxterandthehackers/public-repo",
    "homepage": null,
    "size": 0,
    "stargazers_count": 0,
    "watchers_count": 0,
    "language": null,
    "has_issues": false,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": true,
    "forks_count": 0,
    "mirror_url": null,
    "open_issues_count": 0,
    "forks": 0,
    "open_issues": 0,
    "watchers": 0,
    "default_branch": "master",
    "public": true
  },
  "repository": {
    "id": 35129377,
    "name": "public-repo",
    "full_name": "baxterthehacker/public-repo",
    "owner": {
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
    "private": false,
    "html_url": "https://github.com/baxterthehacker/public-repo",
    "description": "",
    "fork": false,
    "url": "https://api.github.com/repos/baxterthehacker/public-repo",
    "forks_url": "https://api.github.com/repos/baxterthehacker/public-repo/forks",
    "keys_url": "https://api.github.com/repos/baxterthehacker/public-repo/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/baxterthehacker/public-repo/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/baxterthehacker/public-repo/teams",
    "hooks_url": "https://api.github.com/repos/baxterthehacker/public-repo/hooks",
    "issue_events_url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/events{/number}",
    "events_url": "https://api.github.com/repos/baxterthehacker/public-repo/events",
    "assignees_url": "https://api.github.com/repos/baxterthehacker/public-repo/assignees{/user}",
    "branches_url": "https://api.github.com/repos/baxterthehacker/public-repo/branches{/branch}",
    "tags_url": "https://api.github.com/repos/baxterthehacker/public-repo/tags",
    "blobs_url": "https://api.github.com/repos/baxterthehacker/public-repo/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/baxterthehacker/public-repo/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/baxterthehacker/public-repo/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/baxterthehacker/public-repo/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/baxterthehacker/public-repo/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/baxterthehacker/public-repo/languages",
    "stargazers_url": "https://api.github.com/repos/baxterthehacker/public-repo/stargazers",
    "contributors_url": "https://api.github.com/repos/baxterthehacker/public-repo/contributors",
    "subscribers_url": "https://api.github.com/repos/baxterthehacker/public-repo/subscribers",
    "subscription_url": "https://api.github.com/repos/baxterthehacker/public-repo/subscription",
    "commits_url": "https://api.github.com/repos/baxterthehacker/public-repo/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/baxterthehacker/public-repo/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/baxterthehacker/public-repo/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/baxterthehacker/public-repo/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/baxterthehacker/public-repo/contents/{+path}",
    "compare_url": "https://api.github.com/repos/baxterthehacker/public-repo/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/baxterthehacker/public-repo/merges",
    "archive_url": "https://api.github.com/repos/baxterthehacker/public-repo/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/baxterthehacker/public-repo/downloads",
    "issues_url": "https://api.github.com/repos/baxterthehacker/public-repo/issues{/number}",
    "pulls_url": "https://api.github.com/repos/baxterthehacker/public-repo/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/baxterthehacker/public-repo/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/baxterthehacker/public-repo/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/baxterthehacker/public-repo/labels{/name}",
    "releases_url": "https://api.github.com/repos/baxterthehacker/public-repo/releases{/id}",
    "created_at": "2015-05-05T23:40:12Z",
    "updated_at": "2015-05-05T23:40:30Z",
    "pushed_at": "2015-05-05T23:40:27Z",
    "git_url": "git://github.com/baxterthehacker/public-repo.git",
    "ssh_url": "git@github.com:baxterthehacker/public-repo.git",
    "clone_url": "https://github.com/baxterthehacker/public-repo.git",
    "svn_url": "https://github.com/baxterthehacker/public-repo",
    "homepage": null,
    "size": 0,
    "stargazers_count": 0,
    "watchers_count": 0,
    "language": null,
    "has_issues": true,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": true,
    "forks_count": 1,
    "mirror_url": null,
    "open_issues_count": 2,
    "forks": 1,
    "open_issues": 2,
    "watchers": 0,
    "default_branch": "master"
  },
  "sender": {
    "login": "baxterandthehackers",
    "id": 7649605,
    "avatar_url": "https://avatars.githubusercontent.com/u/7649605?v=3",
    "gravatar_id": "",
    "url": "https://api.github.com/users/baxterandthehackers",
    "html_url": "https://github.com/baxterandthehackers",
    "followers_url": "https://api.github.com/users/baxterandthehackers/followers",
    "following_url": "https://api.github.com/users/baxterandthehackers/following{/other_user}",
    "gists_url": "https://api.github.com/users/baxterandthehackers/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/baxterandthehackers/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/baxterandthehackers/subscriptions",
    "organizations_url": "https://api.github.com/users/baxterandthehackers/orgs",
    "repos_url": "https://api.github.com/users/baxterandthehackers/repos",
    "events_url": "https://api.github.com/users/baxterandthehackers/events{/privacy}",
    "received_events_url": "https://api.github.com/users/baxterandthehackers/received_events",
    "type": "Organization",
    "site_admin": false
  }
}
 */