package com.github.typ0520.codee.mvp.bean

import java.io.Serializable

/**
 * Created by tong on 2017/12/26.
 */
data class Repository(
        val id: Int, //35129377
        val name: String, //public-repo
        val full_name: String, //baxterthehacker/public-repo
        val owner: User,
        val private: Boolean, //false
        val html_url: String, //https://github.com/baxterthehacker/public-repo
        val description: String,
        val fork: Boolean, //false
        val url: String, //https://api.github.com/repos/baxterthehacker/public-repo
        val forks_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/forks
        val keys_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/keys{/key_id}
        val collaborators_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/collaborators{/collaborator}
        val teams_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/teams
        val hooks_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/hooks
        val issue_events_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/issues/events{/number}
        val events_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/events
        val assignees_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/assignees{/user}
        val branches_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/branches{/branch}
        val tags_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/tags
        val blobs_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/git/blobs{/sha}
        val git_tags_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/git/tags{/sha}
        val git_refs_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/git/refs{/sha}
        val trees_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/git/trees{/sha}
        val statuses_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/statuses/{sha}
        val languages_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/languages
        val stargazers_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/stargazers
        val contributors_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/contributors
        val subscribers_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/subscribers
        val subscription_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/subscription
        val commits_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/commits{/sha}
        val git_commits_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/git/commits{/sha}
        val comments_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/comments{/number}
        val issue_comment_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/issues/comments{/number}
        val contents_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/contents/{+path}
        val compare_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/compare/{base}...{head}
        val merges_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/merges
        val archive_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/{archive_format}{/ref}
        val downloads_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/downloads
        val issues_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/issues{/number}
        val pulls_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/pulls{/number}
        val milestones_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/milestones{/number}
        val notifications_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/notifications{?since,all,participating}
        val labels_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/labels{/name}
        val releases_url: String, //https://api.github.com/repos/baxterthehacker/public-repo/releases{/id}
        val created_at: String, //2015-05-05T23:40:12Z
        val updated_at: String, //2015-05-05T23:40:12Z
        val pushed_at: String, //2015-05-05T23:40:27Z
        val git_url: String, //git://github.com/baxterthehacker/public-repo.git
        val ssh_url: String, //git@github.com:baxterthehacker/public-repo.git
        val clone_url: String, //https://github.com/baxterthehacker/public-repo.git
        val svn_url: String, //https://github.com/baxterthehacker/public-repo
        val homepage: Any, //null
        val size: Long, //0
        val stargazers_count: Int, //0
        val watchers_count: Int, //0
        val language: String, //null
        val has_issues: Boolean, //true
        val has_downloads: Boolean, //true
        val has_wiki: Boolean, //true
        val has_pages: Boolean, //true
        val forks_count: Int, //0
        val mirror_url: Any, //null
        val open_issues_count: Int, //2
        val forks: Int, //0
        val open_issues: Int, //2
        val watchers: Int, //0
        val default_branch: String, //master
        val subscribers_count: Int,
        var branches_count: Int,
        val parent: Repository?
): Serializable