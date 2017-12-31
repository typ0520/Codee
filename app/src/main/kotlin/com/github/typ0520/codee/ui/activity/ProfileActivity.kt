package com.github.typ0520.codee.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseActivity
import com.github.typ0520.codee.base.EXTRA_USERNAME
import com.github.typ0520.codee.ui.fragment.ProfileFragment
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by tong on 2017/12/27.
 */
class ProfileActivity: BaseActivity() {
    companion object {
        fun start(context: Context, username: String) {
            val intent = Intent(context,ProfileActivity::class.java)
            intent.putExtra(EXTRA_USERNAME, username)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_only_framelayout)

        val fragment = ProfileFragment.newInstance(intent.getStringExtra(EXTRA_USERNAME))
        fragment.setOnViewCreatedHandler {
            fragment.toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white)
            fragment.toolbar.setNavigationOnClickListener {
                finish()
            }
        }
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container,fragment)
                .commit()
    }
}