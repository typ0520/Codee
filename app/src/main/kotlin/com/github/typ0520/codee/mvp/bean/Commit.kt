package com.github.typ0520.codee.mvp.bean

import java.io.Serializable

/**
 * Created by tong on 2017/12/25.
 */
data class Commit(
        val sha: String,
        val id: String, //0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c
        val tree_id: String, //f9d2a07e9488b91af2641b26b9407fe22a451433
        val distinct: Boolean, //true
        val message: String, //Update README.md
        val timestamp: String, //2015-05-05T19:40:15-04:00
        val url: String, //https://github.com/baxterthehacker/public-repo/commit/0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c
        val author: User,
        val committer: User,
        val added: List<String>,
        val removed: List<String>,
        val modified: List<String>
): Serializable