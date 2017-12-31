package com.github.typ0520.codee

import android.app.Application
import android.content.Context
import com.github.typ0520.codee.loadsir.EmptyCallback
import com.github.typ0520.codee.loadsir.ErrorCallback
import com.github.typ0520.codee.loadsir.LoadingCallback
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog
import kotlin.properties.Delegates
import com.elvishew.xlog.LogConfiguration
import com.kingja.loadsir.core.LoadSir
import com.orhanobut.hawk.Hawk

/**
 * Created by tong on 2017/12/19.
 */
class CodeeApplication : Application() {
    companion object {
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
        XLog.init(LogConfiguration.Builder().logLevel(LogLevel.ALL).b().build())
        Hawk.init(context).build()

        LoadSir.beginBuilder()
                .addCallback(ErrorCallback())
                .addCallback(EmptyCallback())
                .addCallback(LoadingCallback())
                .setDefaultCallback(LoadingCallback::class.java)
                .commit()

//        ClassicsFooter.REFRESH_FOOTER_PULLUP = getString(R.string.footer_pullup);//"上拉加载更多";
//        ClassicsFooter.REFRESH_FOOTER_RELEASE = getString(R.string.footer_release);//"释放立即加载";
//        ClassicsFooter.REFRESH_FOOTER_REFRESHING = getString(R.string.footer_refreshing);//"正在刷新...";
//        ClassicsFooter.REFRESH_FOOTER_LOADING = getString(R.string.footer_loading);//"正在加载...";
//        ClassicsFooter.REFRESH_FOOTER_FINISH = getString(R.string.footer_finish);//"加载完成";
//        ClassicsFooter.REFRESH_FOOTER_FAILED = getString(R.string.footer_failed);//"加载失败";
//        ClassicsFooter.REFRESH_FOOTER_ALLLOADED = getString(R.string.footer_allloaded);//"全部加载完成";
    }
}