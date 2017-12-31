package com.github.typ0520.codee.ui.adapter

import android.content.Context
import android.text.TextUtils
import android.widget.TextView
import com.github.typ0520.codee.R
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.ui.activity.RepositoryActivity
import com.github.typ0520.codee.ui.widget.SimpleRecyclerAdapter
import com.github.typ0520.codee.ui.widget.SimpleViewHolder
import com.github.typ0520.codee.utils.goneElseShow

/**
 * Created by tong on 2017/12/30.
 */
open class RepositoryAdapter(val context: Context): SimpleRecyclerAdapter<Repository>(R.layout.list_item_repository) {
    override fun onBindViewHolder(holder: SimpleViewHolder, model: Repository?, position: Int) {
        holder.image(R.id.iv_avatar, model!!.owner.avatar_url, R.drawable.avatar)
        holder.text(R.id.tv_name,model.name)
        (holder.findViewById(R.id.tv_desc) as TextView).run {
            text = model.description
            goneElseShow { TextUtils.isEmpty(model.description) }
        }
        holder.text(R.id.tv_stars, model.stargazers_count.toString())
        holder.text(R.id.tv_forks, model.forks_count.toString())
        holder.text(R.id.tv_owner, model.owner.login)

        holder.findViewById(R.id.ll_root)?.setOnClickListener {
            RepositoryActivity.start(context, model.owner.login, model.name)
        }
    }
}