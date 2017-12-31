package com.github.typ0520.codee.network

import com.github.typ0520.codee.mvp.bean.Event
import com.github.typ0520.codee.mvp.bean.EventList
import com.github.typ0520.codee.mvp.bean.ProjectPayload
import com.github.typ0520.codee.mvp.bean.payload.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sososeen09.multitypejsonparser.parse.MultiTypeJsonParser
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * Created by tong on 2017/12/25.
 */
class SwissArmyKnifeGsonConverterFactory() : Converter.Factory() {
    override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        if (type == String::class.java) {
            return StringResponseBodyConverter
        }
        if (type == JSONObject::class.java) {
            return JSONObjectResponseBodyConverter
        }
        if (type == JSONArray::class.java) {
            return JSONArrayResponseBodyConverter
        }
        if (type == EventList::class.java) {
            return EventListGsonResponseBodyConverter
        }
        return null
    }
}

object StringResponseBodyConverter : Converter<ResponseBody, String> {
    override fun convert(value: ResponseBody): String {
        return value.string()
    }
}

object JSONObjectResponseBodyConverter : Converter<ResponseBody, JSONObject> {
    override fun convert(value: ResponseBody): JSONObject {
        return JSONObject(value.string())
    }
}

object JSONArrayResponseBodyConverter : Converter<ResponseBody, JSONArray> {
    override fun convert(value: ResponseBody): JSONArray {
        return JSONArray(value.string())
    }
}

object EventListGsonResponseBodyConverter : Converter<ResponseBody, EventList> {
    val gson: Gson = createGson()
    val adapter = gson.getAdapter(TypeToken.get(EventList::class.java))

    private fun createGson(): Gson {
        val multiTypeJsonParser = MultiTypeJsonParser.Builder<Payload>()
                .registerTypeElementName("type")
                .registerTargetClass(Payload::class.java)
                .registerTargetUpperLevelClass(Event::class.java)
                .registerTypeElementValueWithClassType(CommitCommentPayload.TYPE_NAME, CommitCommentPayload::class.java)
                .registerTypeElementValueWithClassType(CreatePayload.TYPE_NAME, CreatePayload::class.java)
                .registerTypeElementValueWithClassType(DeletePayload.TYPE_NAME, DeletePayload::class.java)
                .registerTypeElementValueWithClassType(DeploymentPayload.TYPE_NAME, DeploymentPayload::class.java)
                .registerTypeElementValueWithClassType(DeploymentStatusPayload.TYPE_NAME, DeploymentStatusPayload::class.java)
                .registerTypeElementValueWithClassType(DownloadPayload.TYPE_NAME, DownloadPayload::class.java)
                .registerTypeElementValueWithClassType(FollowPayload.TYPE_NAME, FollowPayload::class.java)
                .registerTypeElementValueWithClassType(ForkPayload.TYPE_NAME, ForkPayload::class.java)
                .registerTypeElementValueWithClassType(ForkApplyPayload.TYPE_NAME, ForkApplyPayload::class.java)
                .registerTypeElementValueWithClassType(GistPayload.TYPE_NAME, GistPayload::class.java)
                .registerTypeElementValueWithClassType(GollumPayload.TYPE_NAME, GollumPayload::class.java)
                .registerTypeElementValueWithClassType(InstallationPayload.TYPE_NAME, InstallationPayload::class.java)
                .registerTypeElementValueWithClassType(InstallationRepositoriesPayload.TYPE_NAME, InstallationRepositoriesPayload::class.java)
                .registerTypeElementValueWithClassType(IssueCommentPayload.TYPE_NAME, IssueCommentPayload::class.java)
                .registerTypeElementValueWithClassType(IssuesPayload.TYPE_NAME, IssuesPayload::class.java)
                .registerTypeElementValueWithClassType(LabelPayload.TYPE_NAME, LabelPayload::class.java)
                .registerTypeElementValueWithClassType(MarketplacePurchasePayload.TYPE_NAME, MarketplacePurchasePayload::class.java)
                .registerTypeElementValueWithClassType(MemberPayload.TYPE_NAME, MemberPayload::class.java)
                .registerTypeElementValueWithClassType(MembershipPayload.TYPE_NAME, MembershipPayload::class.java)
                .registerTypeElementValueWithClassType(MilestonePayload.TYPE_NAME, MilestonePayload::class.java)
                .registerTypeElementValueWithClassType(OrganizationPayload.TYPE_NAME, OrganizationPayload::class.java)
                .registerTypeElementValueWithClassType(OrgBlockPayload.TYPE_NAME, OrgBlockPayload::class.java)
                .registerTypeElementValueWithClassType(PageBuildPayload.TYPE_NAME, PageBuildPayload::class.java)
                .registerTypeElementValueWithClassType(ProjectCardPayload.TYPE_NAME, ProjectCardPayload::class.java)
                .registerTypeElementValueWithClassType(ProjectColumnPayload.TYPE_NAME, ProjectColumnPayload::class.java)
                .registerTypeElementValueWithClassType(ProjectPayload.TYPE_NAME, ProjectPayload::class.java)
                .registerTypeElementValueWithClassType(PublicPayload.TYPE_NAME, PublicPayload::class.java)
                .registerTypeElementValueWithClassType(PullRequestPayload.TYPE_NAME, PullRequestPayload::class.java)
                .registerTypeElementValueWithClassType(PullRequestReviewPayload.TYPE_NAME, PullRequestReviewPayload::class.java)
                .registerTypeElementValueWithClassType(PullRequestReviewCommentPayload.TYPE_NAME, PullRequestReviewCommentPayload::class.java)
                .registerTypeElementValueWithClassType(PushPayload.TYPE_NAME, PushPayload::class.java)
                .registerTypeElementValueWithClassType(ReleasePayload.TYPE_NAME, ReleasePayload::class.java)
                .registerTypeElementValueWithClassType(RepositoryPayload.TYPE_NAME, RepositoryPayload::class.java)
                .registerTypeElementValueWithClassType(StatusPayload.TYPE_NAME, StatusPayload::class.java)
                .registerTypeElementValueWithClassType(TeamPayload.TYPE_NAME, TeamPayload::class.java)
                .registerTypeElementValueWithClassType(TeamAddPayload.TYPE_NAME, TeamAddPayload::class.java)
                .registerTypeElementValueWithClassType(WatchPayload.TYPE_NAME, WatchPayload::class.java)
                .build()

        return multiTypeJsonParser.parseGson
    }

    override fun convert(value: ResponseBody): EventList {
        val jsonReader = gson.newJsonReader(value.charStream())
        try {
            return adapter.read(jsonReader) as EventList
        } finally {
            value.close()
        }
    }
}
