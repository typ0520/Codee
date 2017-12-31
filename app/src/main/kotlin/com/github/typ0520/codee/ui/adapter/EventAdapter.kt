package com.github.typ0520.codee.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.github.typ0520.codee.R
import com.github.typ0520.codee.mvp.bean.Event
import com.github.typ0520.codee.utils.gone
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.widget.Toast
import com.github.typ0520.codee.base.EXTRA_USERNAME
import com.github.typ0520.codee.mvp.bean.payload.*
import com.github.typ0520.codee.ui.activity.ProfileActivity
import com.github.typ0520.codee.ui.activity.RepositoryActivity
import com.github.typ0520.codee.ui.widget.BaseRecyclerAdapter
import com.github.typ0520.codee.utils.setImageUrl

/**
 * Created by tong on 2017/12/26.
 */
class EventAdapter(val context: Context): BaseRecyclerAdapter<Event, RecyclerView.ViewHolder>() {
    companion object {
        val VIEW_TYPE_UNKNOWN = -1
        val VIEW_TYPE_COMMON = 0

        //TODO handle payload
        val SUPPORT_TYPE_SET = setOf(
                CommitCommentPayload.TYPE_NAME,
                CreatePayload.TYPE_NAME,
                DeletePayload.TYPE_NAME,
                FollowPayload.TYPE_NAME,
                ForkPayload.TYPE_NAME,
                //ForkApplyPayload.TYPE_NAME,
                //GistPayload.TYPE_NAME,
                //GollumPayload.TYPE_NAME,
                IssueCommentPayload.TYPE_NAME,
                IssuesPayload.TYPE_NAME,
                //MemberPayload.TYPE_NAME,
                PublicPayload.TYPE_NAME,
                PullRequestPayload.TYPE_NAME,
                //PullRequestReviewCommentPayload.TYPE_NAME,
                //PushPayload.TYPE_NAME,
                ReleasePayload.TYPE_NAME,
                //TeamAddPayload.TYPE_NAME
                WatchPayload.TYPE_NAME
        )
    }

    private val layoutInflater = LayoutInflater.from(context)

    override fun getItemViewType(position: Int): Int {
        val event: Event? = getItem(position)
        val typeName = event?.type
        return if (SUPPORT_TYPE_SET.contains(typeName)) VIEW_TYPE_COMMON else VIEW_TYPE_UNKNOWN
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EventViewHolder {
        return if (viewType == VIEW_TYPE_UNKNOWN) {
            val view = View(context)
            view.gone()
            UnknownViewHolder(view)
        }
        else {
            CommonViewHolder()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val event: Event = getItem(position) ?: return
        if (holder is CommonViewHolder) {
            when (event.type) {
                CommitCommentPayload.TYPE_NAME  -> bindCommitCommentViewHolder(holder, event)
                CreatePayload.TYPE_NAME         -> bindCreateViewHolder(holder, event)
                DeletePayload.TYPE_NAME         -> bindDeleteViewHolder(holder, event)
                FollowPayload.TYPE_NAME         -> bindFollowViewHolder(holder, event)
                ForkPayload.TYPE_NAME           -> bindForkViewHolder(holder, event)
                IssueCommentPayload.TYPE_NAME   -> bindIssueCommentViewHolder(holder, event)
                IssuesPayload.TYPE_NAME         -> bindIssuesViewHolder(holder, event)
                PublicPayload.TYPE_NAME         -> bindPublicViewHolder(holder, event)
                PullRequestPayload.TYPE_NAME    -> bindPullRequestViewHolder(holder, event)
                ReleasePayload.TYPE_NAME        -> bindReleaseViewHolder(holder, event)
                WatchPayload.TYPE_NAME          -> bindWatchViewHolder(holder, event)
            }
        }
    }

    private fun bindIssueCommentViewHolder(holder: CommonViewHolder, event: Event) {
        /*
         * typ0520 commented on issue #999 in typ0520/fastdex
         * content
         */
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val actorLogin = event.actor.login
        val payload = event.payload as IssueCommentPayload
        val repoName = event.repo.name

        val str = SpannableString("$actorLogin commented on issue ${payload.issue.id} in $repoName \n${payload.issue.title}")
        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = actorLogin.length + 20
        end = start + payload.issue.id.length
        str.setSpan(IssueClickableSpan(event), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 4
        end = start + repoName.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.tv_content.text = str
    }

    private fun bindFollowViewHolder(holder: CommonViewHolder, event: Event) {
        //typ0520 started following typ0520
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val payload = event.payload as FollowPayload
        val actorLogin = event.actor.login

        val str = SpannableString("$actorLogin started following ${payload.target.login}")

        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 19
        end = start + payload.target.login.length
        str.setSpan(ActorClickableSpan(payload.target.login), start ,end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.tv_content.text = str
    }

    private fun bindDeleteViewHolder(holder: CommonViewHolder, event: Event) {
        //typ0520 published release
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val payload = event.payload as DeletePayload
        val actorLogin = event.actor.login
        val repoName = event.repo.name

        val str = SpannableString("$actorLogin deleted ${payload.ref_type} ${payload.ref} in ${event.repo.name}")

        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 9 + payload.ref_type.length + 1
        end = start + payload.ref.length
        str.setSpan(BranchOrTagClickableSpan(event), start ,end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 4
        end = start + repoName.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start ,end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.tv_content.text = str
    }

    private fun bindReleaseViewHolder(holder: CommonViewHolder, event: Event) {
        //typ0520 published release
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val actorLogin = event.actor.login
        val str = SpannableString("$actorLogin published release")
        holder.tv_content.text = str
    }

    private fun bindCreateViewHolder(holder: CommonViewHolder, event: Event) {
        //typ0520 created repository typ0520/bizsocket
        //typ0520 created tag v1.0.0 in typ0520/bizsocket
        //typ0520 created branch dev in typ0520/bizsocket
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val payload = event.payload as CreatePayload
        val actorLogin = event.actor.login
        val repoName = event.repo.name

        val str: SpannableString = when(payload.ref_type) {
            in CreatePayload.REF_TYPE_TAG, CreatePayload.REF_TYPE_BRANCH
                    -> SpannableString("$actorLogin created ${payload.ref_type} ${payload.ref} in ${event.repo.name}")
            else    -> SpannableString("$actorLogin created ${payload.ref_type} $repoName")
        }

        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        start = end + 9 + payload.ref_type.length + 1

        when(payload.ref_type) {
            in CreatePayload.REF_TYPE_TAG, CreatePayload.REF_TYPE_BRANCH    -> {
                end = start + payload.ref.length
                str.setSpan(BranchOrTagClickableSpan(event), start ,end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                start = end + 4
            }
        }
        end = start + repoName.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start ,end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.tv_content.text = str
    }

    private fun bindPublicViewHolder(holder: CommonViewHolder, event: Event) {
        //typ0520 has open sourced repo
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val payload = event.payload as PublicPayload
        val actorLogin = event.actor.login

        val str = SpannableString("$actorLogin has open sourced ${event.repo.name}")

        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 18
        end = start + event.repo.name.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start ,end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        holder.tv_content.text = str
    }

    private fun bindCommitCommentViewHolder(holder: CommonViewHolder, event: Event) {
        /*
         * typ0520 commented on commit e56979 in typ0520/fastdex
         * content
         */
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val actorLogin = event.actor.login
        val payload = event.payload as CommitCommentPayload
        val repoName = event.repo.name

        val hash = payload.comment.commit_id.substring(0,6)

        val str = SpannableString("$actorLogin commented on commit $hash in $repoName \n${payload.comment.body}")
        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = actorLogin.length + 21
        end = start + hash.length
        str.setSpan(CommentClickableSpan(event), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 4
        end = start + repoName.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.tv_content.text = str
    }

    private fun bindPullRequestViewHolder(holder: CommonViewHolder, event: Event) {
        /*
        * typ0520 opened issue #9999 in typ0520/fastdex
        * content
        */
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val actorLogin = event.actor.login
        val payload = event.payload as PullRequestPayload
        val repoName = event.repo.name

        val str = SpannableString("$actorLogin ${payload.action} pull request #${payload.number} in $repoName \n${payload.pull_request.title}")
        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = actorLogin.length + payload.action.length + 15
        end = start + payload.number.length + 1
        str.setSpan(PullRequestClickableSpan(event), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 4
        end = start + repoName.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.tv_content.text = str
    }

    private fun bindIssuesViewHolder(holder: CommonViewHolder, event: Event) {
        /*
         * typ0520 opened issue #9999 in typ0520/fastdex
         * content
         */
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val actorLogin = event.actor.login
        val payload = event.payload as IssuesPayload
        val repoName = event.repo.name

        val str = SpannableString("$actorLogin ${payload.action} issue #${payload.issue.number} to $repoName \n${payload.issue.title}")
        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = actorLogin.length + payload.action.length + 8
        end = start + payload.issue.number.length + 1
        str.setSpan(IssueClickableSpan(event), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 4
        end = start + repoName.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.tv_content.text = str
    }

    private fun bindForkViewHolder(holder: CommonViewHolder, event: Event) {
        //typ0520 forked googlesamples/android-architecture to typ0520/android-architecture
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val actorLogin = event.actor.login
        val repoName = event.repo.name
        val payload = event.payload as ForkPayload

        val str = SpannableString("$actorLogin forked $repoName to ${payload.forkee.full_name}")

        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 8
        end = start + repoName.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + 4
        end = start + payload.forkee.full_name.length
        str.setSpan(RepoClickableSpan(payload.forkee.full_name), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        holder.tv_content.text = str
    }

    private fun bindWatchViewHolder(holder: CommonViewHolder, event: Event) {
        //typ0520 starred googlesamples/android-architecture
        holder.iv_avatar.setImageUrl(event.actor.avatar_url, R.drawable.login_user_unknown)

        val payload = event.payload as WatchPayload
        val actorLogin = event.actor.login

        val str = SpannableString("$actorLogin ${payload.action} ${event.repo.name}")

        var start = 0
        var end = start + actorLogin.length
        str.setSpan(ActorClickableSpan(actorLogin),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = end + payload.action.length + 2
        end = start + event.repo.name.length
        str.setSpan(RepoClickableSpan(event.repo.full_name), start ,end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        holder.tv_content.text = str
    }

    inner abstract class BlueClickableSpan: ClickableSpan() {
        override fun updateDrawState(ds: TextPaint?) {
            super.updateDrawState(ds)

            ds?.color = context.resources.getColor(R.color.blue)
            ds?.isUnderlineText = false
        }
    }

    inner class ActorClickableSpan(val username: String): BlueClickableSpan() {
        override fun onClick(widget: View?) {
            val intent = Intent(context,ProfileActivity::class.java)
            intent.putExtra(EXTRA_USERNAME,username)
            context.startActivity(intent)
        }
    }

    inner class PullRequestClickableSpan(val event: Event): BlueClickableSpan() {
        override fun onClick(widget: View?) {
            Toast.makeText(context,"pullRequest", Toast.LENGTH_SHORT).show()
        }
    }

    inner class BranchOrTagClickableSpan(val event: Event): BlueClickableSpan() {
        override fun onClick(widget: View?) {
            Toast.makeText(context,"branchOrTag", Toast.LENGTH_SHORT).show()
        }
    }

    inner class RepoClickableSpan(val fullName: String): BlueClickableSpan() {
        override fun onClick(widget: View?) {
            RepositoryActivity.start(context, fullName)
        }
    }

    inner class IssueClickableSpan(val event: Event): BlueClickableSpan() {
        override fun onClick(widget: View?) {
            Toast.makeText(context,"issue", Toast.LENGTH_SHORT).show()
        }
    }

    inner class CommentClickableSpan(val event: Event): BlueClickableSpan() {
        override fun onClick(widget: View?) {
            Toast.makeText(context,"comment", Toast.LENGTH_SHORT).show()
        }
    }

    inner abstract class EventViewHolder: RecyclerView.ViewHolder {
        constructor(layoutId: Int): this(layoutInflater.inflate(layoutId,null))

        constructor(itemView: View): super(itemView)
    }

    inner class UnknownViewHolder(itemView: View): EventViewHolder(itemView)

    inner class CommonViewHolder : EventViewHolder(R.layout.list_item_event_content) {
        val iv_avatar: ImageView = itemView.findViewById(R.id.iv_avatar)
        val tv_content: TextView = itemView.findViewById(R.id.tv_content)

        init {
            tv_content.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}