#!/usr/bin/env bash

#!/bin/bash

for item in $(cat << EOF
CommitCommentEvent
CreateEvent
DeleteEvent
DeploymentEvent
DeploymentStatusEvent
DownloadEvent
FollowEvent
ForkEvent
ForkApplyEvent
GistEvent
GollumEvent
InstallationEvent
InstallationRepositoriesEvent
IssueCommentEvent
IssuesEvent
LabelEvent
MarketplacePurchaseEvent
MemberEvent
MembershipEvent
MilestoneEvent
OrganizationEvent
OrgBlockEvent
PageBuildEvent
ProjectCardEvent
ProjectColumnEvent
ProjectEvent
PublicEvent
PullRequestEvent
PullRequestReviewEvent
PullRequestReviewCommentEvent
PushEvent
ReleaseEvent
RepositoryEvent
StatusEvent
TeamEvent
TeamAddEvent
WatchEvent
EOF
);do
	echo ".registerTypeElementValueWithClassType($(echo $item | sed 's/Event//g')Payload.TYPE_NAME, ${item}Payload::class.java)"
done