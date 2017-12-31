package com.github.typ0520.codee

import com.github.typ0520.codee.mvp.bean.Event
import com.github.typ0520.codee.mvp.bean.EventList
import com.github.typ0520.codee.mvp.bean.payload.*
import com.sososeen09.multitypejsonparser.parse.MultiTypeJsonParser
import junit.framework.TestCase
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert
import org.junit.Test

/**
 * Created by tong on 2017/12/25.
 */

//CommitCommentEvent
//CreateEvent
//DeleteEvent
//DeploymentEvent
//DeploymentStatusEvent
//DownloadEvent
//FollowEvent
//ForkEvent
//ForkApplyEvent
//GistEvent
//GollumEvent
//InstallationEvent
//InstallationRepositoriesEvent
//IssueCommentEvent
//IssuesEvent
//LabelEvent
//MarketplacePurchaseEvent
//MemberEvent
//MembershipEvent
//MilestoneEvent
//OrganizationEvent
//OrgBlockEvent
//PageBuildEvent
//ProjectCardEvent
//ProjectColumnEvent
//ProjectEvent
//PublicEvent
//PullRequestEvent
//PullRequestReviewEvent
//PullRequestReviewCommentEvent
//PushEvent
//ReleaseEvent
//RepositoryEvent
//StatusEvent
//TeamEvent
//TeamAddEvent
//WatchEvent

class MultiTypeJsonParserTest: TestCase() {
    @Test
    fun testParseCommitCommentPayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(CommitCommentPayload.TYPE_NAME, CommitCommentPayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_COMMIT_COMMENT_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(CommitCommentPayload::class.java,list.get(0).payload!!.javaClass)
    }

    @Test
    fun testParseCreatePayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(CreatePayload.TYPE_NAME, CreatePayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_CREATE_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(CreatePayload::class.java,list.get(0).payload!!.javaClass)
    }

    @Test
    fun testParseDeletePayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(DeletePayload.TYPE_NAME, DeletePayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_DELETE_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(DeletePayload::class.java,list.get(0).payload!!.javaClass)
    }

    @Test
    fun testParseDeploymentPayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(DeploymentPayload.TYPE_NAME, DeploymentPayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_DEPLOYMENT_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(DeploymentPayload::class.java,list.get(0).payload!!.javaClass)
    }

    @Test
    fun testParseDeploymentStatusPayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(DeploymentStatusPayload.TYPE_NAME, DeploymentStatusPayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_DEPLOYMENT_STATUS_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(DeploymentStatusPayload::class.java,list.get(0).payload!!.javaClass)
    }

    @Test
    fun testParseDownloadPayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(DownloadPayload.TYPE_NAME, DownloadPayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_DOWNLOAD_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(DownloadPayload::class.java,list.get(0).payload!!.javaClass)
    }

    @Test
    fun testParseFollowPayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(FollowPayload.TYPE_NAME, FollowPayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_FOLLOW_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(FollowPayload::class.java,list.get(0).payload!!.javaClass)
    }

    @Test
    fun testParseForkPayload() {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(ForkPayload.TYPE_NAME, ForkPayload::class.java)
                .build()

        val jsonArray = JSONArray()
        jsonArray.put(JSONObject(TEST_FORK_PAYLOAD_JSON))
        val list: EventList = multiTypeJsonParser.fromJson(jsonArray.toString(), EventList::class.java)
        Assert.assertEquals(ForkPayload::class.java,list.get(0).payload!!.javaClass)
    }
}

const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "CommitCommentEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
          "action": "created",
          "comment": {
            "url": "https://api.github.com/repos/baxterthehacker/public-repo/comments/11056394",
            "html_url": "https://github.com/baxterthehacker/public-repo/commit/9049f1265b7d61be4a8904a9a27120d2064dab3b#commitcomment-11056394",
            "id": 11056394,
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
            "position": null,
            "line": null,
            "path": null,
            "commit_id": "9049f1265b7d61be4a8904a9a27120d2064dab3b",
            "created_at": "2015-05-05T23:40:29Z",
            "updated_at": "2015-05-05T23:40:29Z",
            "body": "This is a really good change! :+1:"
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
            "updated_at": "2015-05-05T23:40:12Z",
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
            "forks_count": 0,
            "mirror_url": null,
            "open_issues_count": 2,
            "forks": 0,
            "open_issues": 2,
            "watchers": 0,
            "default_branch": "master"
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
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """

const val TEST_CREATE_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "CreateEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
          "ref": "0.0.1",
          "ref_type": "tag",
          "master_branch": "master",
          "description": "",
          "pusher_type": "user",
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
            "pushed_at": "2015-05-05T23:40:38Z",
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
            "forks_count": 0,
            "mirror_url": null,
            "open_issues_count": 2,
            "forks": 0,
            "open_issues": 2,
            "watchers": 0,
            "default_branch": "master"
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
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """

const val TEST_DELETE_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "DeleteEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
          "ref": "simple-tag",
          "ref_type": "tag",
          "pusher_type": "user",
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
            "pushed_at": "2015-05-05T23:40:40Z",
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
            "forks_count": 0,
            "mirror_url": null,
            "open_issues_count": 2,
            "forks": 0,
            "open_issues": 2,
            "watchers": 0,
            "default_branch": "master"
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
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """

const val TEST_DEPLOYMENT_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "DeploymentEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
          "deployment": {
            "url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692",
            "id": 710692,
            "sha": "9049f1265b7d61be4a8904a9a27120d2064dab3b",
            "ref": "master",
            "task": "deploy",
            "payload": {
            },
            "environment": "production",
            "description": null,
            "creator": {
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
            "created_at": "2015-05-05T23:40:38Z",
            "updated_at": "2015-05-05T23:40:38Z",
            "statuses_url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692/statuses",
            "repository_url": "https://api.github.com/repos/baxterthehacker/public-repo"
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
            "pushed_at": "2015-05-05T23:40:38Z",
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
            "forks_count": 0,
            "mirror_url": null,
            "open_issues_count": 2,
            "forks": 0,
            "open_issues": 2,
            "watchers": 0,
            "default_branch": "master"
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
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """

const val TEST_DEPLOYMENT_STATUS_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "DeploymentStatusEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
          "deployment_status": {
            "url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692/statuses/1115122",
            "id": 1115122,
            "state": "success",
            "creator": {
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
            "description": null,
            "target_url": null,
            "created_at": "2015-05-05T23:40:39Z",
            "updated_at": "2015-05-05T23:40:39Z",
            "deployment_url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692",
            "repository_url": "https://api.github.com/repos/baxterthehacker/public-repo"
          },
          "deployment": {
            "url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692",
            "id": 710692,
            "sha": "9049f1265b7d61be4a8904a9a27120d2064dab3b",
            "ref": "master",
            "task": "deploy",
            "payload": {
            },
            "environment": "production",
            "description": null,
            "creator": {
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
            "created_at": "2015-05-05T23:40:38Z",
            "updated_at": "2015-05-05T23:40:38Z",
            "statuses_url": "https://api.github.com/repos/baxterthehacker/public-repo/deployments/710692/statuses",
            "repository_url": "https://api.github.com/repos/baxterthehacker/public-repo"
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
            "pushed_at": "2015-05-05T23:40:38Z",
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
            "forks_count": 0,
            "mirror_url": null,
            "open_issues_count": 2,
            "forks": 0,
            "open_issues": 2,
            "watchers": 0,
            "default_branch": "master"
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
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """

const val TEST_DOWNLOAD_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "DownloadEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
            "url": "https://api.github.com/repos/octocat/Hello-World/downloads/1",
            "html_url": "https://github.com/repos/octocat/Hello-World/downloads/new_file.jpg",
            "id": 1,
            "name": "new_file.jpg",
            "description": "Description of your download",
            "size": 1024,
            "download_count": 40,
            "content_type": ".jpg"
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """

const val TEST_FOLLOW_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "FollowEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {

        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """

const val TEST_FORK_PAYLOAD_JSON = """
      {
        "id": "7027686618",
        "type": "ForkEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
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
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    """
//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """
//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    """

//
//const val TEST_COMMIT_COMMENT_PAYLOAD_JSON = """
//    [
//      {
//        "id": "7027686618",
//        "type": "IssuesEvent",
//        "actor": {
//          "id": 22332838,
//          "login": "arranlomas",
//          "display_login": "arranlomas",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/arranlomas",
//          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
//        },
//        "repo": {
//          "id": 51148780,
//          "name": "googlesamples/android-architecture",
//          "url": "https://api.github.com/repos/googlesamples/android-architecture"
//        },
//        "payload": {
//
//        },
//        "public": true,
//        "created_at": "2017-12-25T01:30:29Z",
//        "org": {
//          "id": 7378196,
//          "login": "googlesamples",
//          "gravatar_id": "",
//          "url": "https://api.github.com/orgs/googlesamples",
//          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
//        }
//      }
//    ]
//    """


const val TEST_JSON1 = """
    [
      {
        "id": "7028083427",
        "type": "WatchEvent",
        "actor": {
          "id": 5214214,
          "login": "drakeet",
          "display_login": "drakeet",
          "gravatar_id": "",
          "url": "https://api.github.com/users/drakeet",
          "avatar_url": "https://avatars.githubusercontent.com/u/5214214?"
        },
        "repo": {
          "id": 16415381,
          "name": "halloffame/ynab-csv",
          "url": "https://api.github.com/repos/halloffame/ynab-csv"
        },
        "payload": {
          "action": "started"
        },
        "public": true,
        "created_at": "2017-12-25T06:38:57Z"
      },
      {
        "id": "7027686618",
        "type": "IssuesEvent",
        "actor": {
          "id": 22332838,
          "login": "arranlomas",
          "display_login": "arranlomas",
          "gravatar_id": "",
          "url": "https://api.github.com/users/arranlomas",
          "avatar_url": "https://avatars.githubusercontent.com/u/22332838?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
          "action": "closed",
          "issue": {
            "url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481",
            "repository_url": "https://api.github.com/repos/googlesamples/android-architecture",
            "labels_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481/labels{/name}",
            "comments_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481/comments",
            "events_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481/events",
            "html_url": "https://github.com/googlesamples/android-architecture/issues/481",
            "id": 284292496,
            "number": 481,
            "title": "New sample: Kotlin MVI with dagger and RxJAva",
            "user": {
              "login": "arranlomas",
              "id": 22332838,
              "avatar_url": "https://avatars1.githubusercontent.com/u/22332838?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/arranlomas",
              "html_url": "https://github.com/arranlomas",
              "followers_url": "https://api.github.com/users/arranlomas/followers",
              "following_url": "https://api.github.com/users/arranlomas/following{/other_user}",
              "gists_url": "https://api.github.com/users/arranlomas/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/arranlomas/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/arranlomas/subscriptions",
              "organizations_url": "https://api.github.com/users/arranlomas/orgs",
              "repos_url": "https://api.github.com/users/arranlomas/repos",
              "events_url": "https://api.github.com/users/arranlomas/events{/privacy}",
              "received_events_url": "https://api.github.com/users/arranlomas/received_events",
              "type": "User",
              "site_admin": false
            },
            "labels": [],
            "state": "closed",
            "locked": false,
            "assignee": null,
            "assignees": [],
            "milestone": null,
            "comments": 2,
            "created_at": "2017-12-23T07:43:32Z",
            "updated_at": "2017-12-25T01:30:28Z",
            "closed_at": "2017-12-25T01:30:28Z",
            "author_association": "NONE",
            "body": "I plan on making an example of the TODO app as a proposal to use this architecture in my organization. It will be using mvi, kotlin, dagger and RxJava, I am also working on a series of articles to accompany. This is heavily influenced by the Java MVI sample. However, now kotlin is a 1st party language, a think a sample of this architecture would be useful as this architecture lends itself very well to this architecture. \r\n\r\nYou can see the start of this work [here](https://github.com/arranlomas/kontent)"
          }
        },
        "public": true,
        "created_at": "2017-12-25T01:30:29Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      },
      {
        "id": "7027390502",
        "type": "PushEvent",
        "actor": {
          "id": 1644068,
          "login": "thedillonb",
          "display_login": "thedillonb",
          "gravatar_id": "",
          "url": "https://api.github.com/users/thedillonb",
          "avatar_url": "https://avatars.githubusercontent.com/u/1644068?"
        },
        "repo": {
          "id": 11620669,
          "name": "CodeHubApp/CodeHub",
          "url": "https://api.github.com/repos/CodeHubApp/CodeHub"
        },
        "payload": {
          "push_id": 2216192667,
          "size": 2,
          "distinct_size": 1,
          "ref": "refs/heads/develop",
          "head": "b9463384688deb103432e1733594e3c06bd28f26",
          "before": "78a1fe7634fafde6773bda8bd05d9383a7c6ad98",
          "commits": [
            {
              "sha": "a0639269b96576b5a2a3155b285b5e7078765669",
              "author": {
                "email": "thedillonb@gmail.com",
                "name": "Dillon Buchanan"
              },
              "message": "Restore Issue/PullRequest Description\n\nFixes #409",
              "distinct": false,
              "url": "https://api.github.com/repos/CodeHubApp/CodeHub/commits/a0639269b96576b5a2a3155b285b5e7078765669"
            },
            {
              "sha": "b9463384688deb103432e1733594e3c06bd28f26",
              "author": {
                "email": "thedillonb@gmail.com",
                "name": "Dillon Buchanan"
              },
              "message": "Refactoring Issues and PullRequests",
              "distinct": true,
              "url": "https://api.github.com/repos/CodeHubApp/CodeHub/commits/b9463384688deb103432e1733594e3c06bd28f26"
            }
          ]
        },
        "public": true,
        "created_at": "2017-12-24T19:41:47Z",
        "org": {
          "id": 31394933,
          "login": "CodeHubApp",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/CodeHubApp",
          "avatar_url": "https://avatars.githubusercontent.com/u/31394933?"
        }
      },
      {
        "id": "7027642720",
        "type": "IssueCommentEvent",
        "actor": {
          "id": 1767669,
          "login": "oldergod",
          "display_login": "oldergod",
          "gravatar_id": "",
          "url": "https://api.github.com/users/oldergod",
          "avatar_url": "https://avatars.githubusercontent.com/u/1767669?"
        },
        "repo": {
          "id": 51148780,
          "name": "googlesamples/android-architecture",
          "url": "https://api.github.com/repos/googlesamples/android-architecture"
        },
        "payload": {
          "action": "created",
          "issue": {
            "url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481",
            "repository_url": "https://api.github.com/repos/googlesamples/android-architecture",
            "labels_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481/labels{/name}",
            "comments_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481/comments",
            "events_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481/events",
            "html_url": "https://github.com/googlesamples/android-architecture/issues/481",
            "id": 284292496,
            "number": 481,
            "title": "New sample: Kotlin MVI with dagger and RxJAva",
            "user": {
              "login": "arranlomas",
              "id": 22332838,
              "avatar_url": "https://avatars1.githubusercontent.com/u/22332838?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/arranlomas",
              "html_url": "https://github.com/arranlomas",
              "followers_url": "https://api.github.com/users/arranlomas/followers",
              "following_url": "https://api.github.com/users/arranlomas/following{/other_user}",
              "gists_url": "https://api.github.com/users/arranlomas/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/arranlomas/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/arranlomas/subscriptions",
              "organizations_url": "https://api.github.com/users/arranlomas/orgs",
              "repos_url": "https://api.github.com/users/arranlomas/repos",
              "events_url": "https://api.github.com/users/arranlomas/events{/privacy}",
              "received_events_url": "https://api.github.com/users/arranlomas/received_events",
              "type": "User",
              "site_admin": false
            },
            "labels": [

            ],
            "state": "open",
            "locked": false,
            "assignee": null,
            "assignees": [

            ],
            "milestone": null,
            "comments": 0,
            "created_at": "2017-12-23T07:43:32Z",
            "updated_at": "2017-12-25T00:47:41Z",
            "closed_at": null,
            "author_association": "NONE",
            "body": "I plan on making an example of the TODO app as a proposal to use this architecture in my organization. It will be using mvi, kotlin, dagger and RxJava, I am also working on a series of articles to accompany. This is heavily influenced by the Java MVI sample. However, now kotlin is a 1st party language, a think a sample of this architecture would be useful as this architecture lends itself very well to this architecture. \r\n\r\nYou can see the start of this work [here](https://github.com/arranlomas/kontent)"
          },
          "comment": {
            "url": "https://api.github.com/repos/googlesamples/android-architecture/issues/comments/353810338",
            "html_url": "https://github.com/googlesamples/android-architecture/issues/481#issuecomment-353810338",
            "issue_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/481",
            "id": 353810338,
            "user": {
              "login": "oldergod",
              "id": 1767669,
              "avatar_url": "https://avatars3.githubusercontent.com/u/1767669?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/oldergod",
              "html_url": "https://github.com/oldergod",
              "followers_url": "https://api.github.com/users/oldergod/followers",
              "following_url": "https://api.github.com/users/oldergod/following{/other_user}",
              "gists_url": "https://api.github.com/users/oldergod/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/oldergod/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/oldergod/subscriptions",
              "organizations_url": "https://api.github.com/users/oldergod/orgs",
              "repos_url": "https://api.github.com/users/oldergod/repos",
              "events_url": "https://api.github.com/users/oldergod/events{/privacy}",
              "received_events_url": "https://api.github.com/users/oldergod/received_events",
              "type": "User",
              "site_admin": false
            },
            "created_at": "2017-12-25T00:47:41Z",
            "updated_at": "2017-12-25T00:47:41Z",
            "author_association": "NONE",
            "body": "btw, the `todo-mvi-rxjava` will be rewritten in Kotlin before the [DroidKaigi](https://droidkaigi.jp/2018/) conference."
          }
        },
        "public": true,
        "created_at": "2017-12-25T00:47:42Z",
        "org": {
          "id": 7378196,
          "login": "googlesamples",
          "gravatar_id": "",
          "url": "https://api.github.com/orgs/googlesamples",
          "avatar_url": "https://avatars.githubusercontent.com/u/7378196?"
        }
      }
    ]
    """