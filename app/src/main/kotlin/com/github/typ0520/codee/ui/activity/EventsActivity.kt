package com.github.typ0520.codee.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseActivity
import com.github.typ0520.codee.ui.fragment.EventsFragment
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by tong on 2017-12-30.
 */
class EventsActivity : BaseActivity() {
    companion object {
        fun startEvents(context: Context, ownerName: String) = start(context, EventsFragment.MODEL_TYPE_EVNETS, ownerName)

        fun startRepoEvents(context: Context, ownerName: String, repoName: String) = start(context, EventsFragment.MODEL_TYPE_REPO_EVENTS, ownerName, repoName)

        private fun start(context: Context, modelType: String, ownerName: String, repoName: String = "") {
            val intent = Intent(context, EventsActivity::class.java)
            intent.putExtra(EventsFragment.EXTRA_MODEL_TYPE,modelType)
            intent.putExtra(EventsFragment.EXTRA_OWNER_NAME,ownerName)
            intent.putExtra(EventsFragment.EXTRA_REPO_NAME,repoName)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_only_framelayout)

        val fragment = EventsFragment.newInstance(intent.extras)
        fragment.setOnViewCreatedHandler {
            fragment.toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white)
            fragment.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container,fragment)
                .commit()
    }
}

