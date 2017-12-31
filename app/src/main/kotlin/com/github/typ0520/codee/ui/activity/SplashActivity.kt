package com.github.typ0520.codee.ui.activity

import android.content.Intent
import android.os.Bundle
import com.github.typ0520.codee.base.BaseActivity
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017/12/20.
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //resolve launcher'bug
        if (isLauncherStart()) {
            return
        }
        handler.postDelayed({
            startActivity(Intent(this,getTragetClass()))
            finish()
        },1000)
    }

    private fun getTragetClass(): Class<*>? {
        val user: User? = User.current()
        return if (user == null) AuthorizeActivity::class.java else LoginActivity::class.java
    }

    private fun isLauncherStart(): Boolean {
        if (!this.isTaskRoot) {
            val intent = intent
            if (intent != null) {
                val action = intent.action
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN == action) {
                    finish()
                    return true
                }
            }
        }
        return false
    }
}