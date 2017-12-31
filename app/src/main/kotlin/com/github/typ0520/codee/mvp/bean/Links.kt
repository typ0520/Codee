package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */

data class Links(
        val self: Link,
        val html: Link,
        val issue: Link,
        val comments: Link,
        val review_comments: Link,
        val review_comment: Link,
        val commits: Link,
        val statuses: Link
)

data class Link(
        val href: String //https://api.github.com/repos/octocat/Hello-World/pulls/comments{/number}
)