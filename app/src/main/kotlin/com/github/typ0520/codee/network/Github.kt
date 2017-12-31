package com.github.typ0520.codee.network

import com.github.typ0520.codee.BuildConfig
import com.github.typ0520.codee.base.DEFAULT_PER_PAGE
import com.github.typ0520.codee.mvp.bean.*
import com.github.typ0520.codee.network.route.Scope
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by tong on 2017/12/21.
 */
interface Github {
    companion object {
        const val BASE_URL_GITHUB = "https://github.com/"
        const val BASE_URL_API = "https://api.github.com/"
        const val BASE_URL_TRENDING = "http://trending.codehub-app.com/"
    }

    @Scope(BASE_URL_GITHUB)
    @POST("login/oauth/access_token")
    fun requestAccessToken(@Query("code") code: String,
                           @Query("client_id") clientId: String = BuildConfig.CLIENT_ID,
                           @Query("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET): Observable<String>

    @GET("user")
    fun getUserInfoByAccessToken(@Query("access_token") accessToken: String): Observable<User>

    @GET("users/{ownerName}")
    fun getUserInfo(@Path("ownerName") username: String): Observable<User>

    @GET("users/{ownerName}/followers")
    fun getFollowers(@Path("ownerName") username: String,
                     @Query("page") page: Int = 1,
                     @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<User>>

    @GET("users/{ownerName}/following")
    fun getFollowing(@Path("ownerName") username: String,
                     @Query("page") page: Int = 1,
                     @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<User>>

    //https://api.github.com/repos/typ0520/fastdex/watchers
    @GET("repos/{ownerName}/{repoName}/watchers")
    fun getWatchers(@Path("ownerName") ownerName: String,
                    @Path("repoName") repoName: String,
                    @Query("page") page: Int = 1,
                    @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<User>>

    //https://api.github.com/repos/typ0520/bizsocket/stargazers
    @GET("repos/{ownerName}/{repoName}/stargazers")
    fun getStargazers(@Path("ownerName") ownerName: String,
                      @Path("repoName") repoName: String,
                      @Query("page") page: Int = 1,
                      @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<User>>

    //https://api.github.com/users/typ0520/received_events/public?page=1&per_page=1000
    @GET("users/{ownerName}/received_events/public")
    fun getReceivedEvents(@Path("ownerName") username: String,
                          @Query("page") page: Int = 1,
                          @Query("per_page") per_page: Int = DEFAULT_PER_PAGE)
            : Observable<EventList>

    @GET("users/{ownerName}/events/public")
    fun getUserEvents(@Path("ownerName") username: String,
                      @Query("page") page: Int = 1,
                      @Query("per_page") per_page: Int = DEFAULT_PER_PAGE)
            : Observable<EventList>

    @GET("repos/{ownerName}/{repoName}/events")
    fun getRepoEvents(@Path("ownerName") username: String,
                      @Path("repoName") repoName: String,
                      @Query("page") page: Int = 1,
                      @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<EventList>

    //https://api.github.com/repos/typ0520/fastdex
    @GET("repos/{ownerName}/{repoName}")
    fun getRepository(@Path("ownerName") ownerName: String,
                      @Path("repoName") repoName: String): Observable<Repository>

    @GET("repos/{ownerName}/{repoName}/forks")
    fun getForks(@Path("ownerName") ownerName: String,
                 @Path("repoName") repoName: String,
                 @Query("page") page: Int = 1,
                 @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<Repository>>

    @GET("users/{ownerName}/repos")
    fun getUserRepos(@Path("ownerName") ownerName: String,
                     @Query("page") page: Int = 1,
                     @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<Repository>>

    @GET("users/{ownerName}/starred")
    fun getStarredRepos(@Path("ownerName") ownerName: String,
                        @Query("page") page: Int = 1,
                        @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<Repository>>

    //http://trending.codehub-app.com/v2/
    @Scope(BASE_URL_TRENDING)
    @GET("/v2/trending")
    fun getTrendingRepos(@Query("since") since: String,
                         @Query("language") language: String): Observable<List<Repository>>

    @GET("repos/{ownerName}/{repoName}/branches")
    fun getBranches(@Path("ownerName") ownerName: String,
                    @Path("repoName") repoName: String,
                    @Query("page") page: Int = 1,
                    @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<Branche>>

    @GET("repos/{ownerName}/{repoName}/issues")
    fun getIssues(@Path("ownerName") ownerName: String,
                  @Path("repoName") repoName: String,
                  @Query("state") state: String = "all",
                  @Query("page") page: Int = 1,
                  @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<Issue>>

    @GET("repos/{ownerName}/{repoName}/issues")
    fun getUserIssues(@Path("ownerName") ownerName: String,
                      @Path("repoName") repoName: String,
                      @Query("state") state: String = "all",
                      @Query("creator") creator: String,
                      @Query("page") page: Int = 1,
                      @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<List<Issue>>

    //https://api.github.com/search/repositories?q=typ0520&page=1&per_page=1
    @GET("search/repositories")
    fun searchRepositories(@Query("q") keyword: String,
                           @Query("page") page: Int = 1,
                           @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<SearchResponse<Repository>>

    //https://api.github.com/search/users?q=typ0520&page=1&per_page=1
    @GET("search/users")
    fun searchUsers(@Query("q") keyword: String,
                    @Query("page") page: Int = 1,
                    @Query("per_page") per_page: Int = DEFAULT_PER_PAGE): Observable<SearchResponse<User>>
}