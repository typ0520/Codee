package com.github.typ0520.codee.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.tiagohm.markdownview.css.styles.Github
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseActivity
import kotlinx.android.synthetic.main.activity_markdown.*

/**
 * Created by tong on 2017-12-29.
 */
class MarkdownActivity : BaseActivity() {
    companion object {
        val EXTRA_TITLE = "title"
        val EXTRA_DOC_URL = "doc_url"

        fun start(context: Context, title: String, docUrl: String) {
            val intent = Intent(context,MarkdownActivity::class.java)
            intent.putExtra(EXTRA_TITLE, title)
            intent.putExtra(EXTRA_DOC_URL, docUrl)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markdown)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val docUrl = intent.getStringExtra(EXTRA_DOC_URL)

        toolbar.title = title
        
        val style = Github()
        markdown_view.addStyleSheet(style)
        style.addMedia("screen and (min-width: 320px)")
        style.addRule("h1", "color: green")
        style.endMedia()
        style.addMedia("screen and (min-width: 481px)")
        style.addRule("h1", "color: red")
        style.endMedia()
        style.addMedia("screen and (min-width: 641px)")
        style.addRule("h1", "color: blue")
        style.endMedia()
        style.addMedia("screen and (min-width: 961px)")
        style.addRule("h1", "color: yellow")
        style.endMedia()
        style.addMedia("screen and (min-width: 1025px)")
        style.addRule("h1", "color: gray")
        style.endMedia()
        style.addMedia("screen and (min-width: 1281px)")
        style.addRule("h1", "color: orange")
        style.endMedia()
        markdown_view.loadMarkdownFromUrl(docUrl)
    }
}

