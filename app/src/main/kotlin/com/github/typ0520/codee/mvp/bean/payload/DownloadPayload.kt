package com.github.typ0520.codee.mvp.bean.payload

/**
 * Created by tong on 2017/12/26.
 */

/**
 * Triggered when a new download is created.
 *
 * https://developer.github.com/v3/activity/events/types/#downloadevent
 */
data class DownloadPayload(
		val url: String, //https://api.github.com/repos/octocat/Hello-World/downloads/1
		val html_url: String, //https://github.com/repos/octocat/Hello-World/downloads/new_file.jpg
		val id: Int, //1
		val name: String, //new_file.jpg
		val description: String, //Description of your download
		val size: Int, //1024
		val download_count: Int, //40
		val content_type: String //.jpg
): Payload() {
    companion object {
        val TYPE_NAME = "DownloadEvent"
    }
}

/*
{
    "url": "https://api.github.com/repos/octocat/Hello-World/downloads/1",
    "html_url": "https://github.com/repos/octocat/Hello-World/downloads/new_file.jpg",
    "id": 1,
    "name": "new_file.jpg",
    "description": "Description of your download",
    "size": 1024,
    "download_count": 40,
    "content_type": ".jpg"
 }
 */