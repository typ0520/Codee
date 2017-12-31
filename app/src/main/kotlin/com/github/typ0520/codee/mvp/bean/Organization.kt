package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */

data class Organization(
        val login: String, //baxterandthehackers
        val id: Int, //4312013
        val url: String, //https://api.github.com/orgs/baxterandthehackers
        val repos_url: String, //https://api.github.com/orgs/baxterandthehackers/repos
        val events_url: String, //https://api.github.com/orgs/baxterandthehackers/events
        val hooks_url: String, //https://api.github.com/orgs/baxterandthehackers/hooks
        val issues_url: String, //https://api.github.com/orgs/baxterandthehackers/issues
        val members_url: String, //https://api.github.com/orgs/baxterandthehackers/members{/member}
        val public_members_url: String, //https://api.github.com/orgs/baxterandthehackers/public_members{/member}
        val avatar_url: String, //https://avatars.githubusercontent.com/u/4312013?v=3
        val description: String
)
