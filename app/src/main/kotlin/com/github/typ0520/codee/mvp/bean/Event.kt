package com.github.typ0520.codee.mvp.bean

import com.github.typ0520.codee.mvp.bean.payload.Payload

/**
 * Created by tong on 2017/12/25.
 */
data class Event(
        val id: String,
        val type: String,
        val actor: User,
        val repo: Repo,
        val payload: Payload,
        val public: Boolean,
        val created_at: String
) {
    companion object {
        val EVENT_TYPE_ARRAY = listOf(
                "CommitCommentEvent",
                "CreateEvent",
                "DeleteEvent",
                "DeploymentEvent",
                "DeploymentStatusEvent",
                "DownloadEvent",
                "FollowEvent",
                "ForkEvent",
                "ForkApplyEvent",
                "GistEvent",
                "GollumEvent",
                "InstallationEvent",
                "InstallationRepositoriesEvent",
                "IssueCommentEvent",
                "IssuesEvent",
                "LabelEvent",
                "MarketplacePurchaseEvent",
                "MemberEvent",
                "MembershipEvent",
                "MilestoneEvent",
                "OrganizationEvent",
                "OrgBlockEvent",
                "PageBuildEvent",
                "ProjectCardEvent",
                "ProjectColumnEvent",
                "ProjectEvent",
                "PublicEvent",
                "PullRequestEvent",
                "PullRequestReviewEvent",
                "PullRequestReviewCommentEvent",
                "PushEvent",
                "ReleaseEvent",
                "RepositoryEvent",
                "StatusEvent",
                "TeamEvent",
                "TeamAddEvent",
                "WatchEvent"
        )
    }
}
