package com.github.typ0520.codee.mvp.bean

/**
 * Created by tong on 2017/12/26.
 */
data class Installation(
        val id: Int, //2
        val account: User,
        val repository_selection: String, //selected
        val access_tokens_url: String, //https://api.github.com/installations/2/access_tokens
        val repositories_url: String //https://api.github.com/installation/repositories
)