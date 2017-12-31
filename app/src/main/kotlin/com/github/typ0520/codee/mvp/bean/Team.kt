package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */

data class Team(
        val name: String, //team baxter
        val id: Int, //2175394
        val slug: String, //team-baxter
        val description: String,
        val privacy: String, //secret
        val url: String, //https:/api.github.com/teams/2175394
        val members_url: String, //https:/api.github.com/teams/2175394/members{/member}
        val repositories_url: String, //https:/api.github.com/teams/2175394/repos
        val permission: String //pull
)