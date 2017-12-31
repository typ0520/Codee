package com.github.typ0520.codee.ui.adapter

import android.content.Context
import com.github.typ0520.codee.R
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.ui.activity.ProfileActivity
import com.github.typ0520.codee.ui.widget.SimpleRecyclerAdapter
import com.github.typ0520.codee.ui.widget.SimpleViewHolder

/**
 * Created by tong on 2017/12/30.
 */
class UserAdapter(val context: Context): SimpleRecyclerAdapter<User>(R.layout.list_item_user) {
    override fun onBindViewHolder(holder: SimpleViewHolder, model: User?, position: Int) {
        holder.text(R.id.tv_login, model!!.login)
        holder.image(R.id.iv_avatar, model.avatar_url, R.drawable.login_user_unknown)

        holder.click(R.id.ll_root, { ProfileActivity.start(context, model.login) })
    }
}