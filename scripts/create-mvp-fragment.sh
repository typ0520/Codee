#!/usr/bin/env bash

source $(dirname $0)/mvp-common.sh

name=$1
if [ -z "${name}" ];then
    echo "map-generator: please input name"
    exit -1
fi

if [ -f setting.gradle1 ];then
    echo "map-generator: please use this script on gradle root path"
    exit -1
fi

current_date=$(date '+%Y-%m-%d')
controller_file=app/src/main/kotlin/cn/dp20/githubclient/ui/fragment/${name}Fragment.kt
layout_file_prefix_name=fragment_$(class_name_2_file_name $name)
layout_file_name=$layout_file_prefix_name.xml
layout_file=app/src/main/res/layout/$layout_file_name
contact_file=app/src/main/kotlin/cn/dp20/githubclient/mvp/contract/${name}Contract.kt
presenter_file=app/src/main/kotlin/cn/dp20/githubclient/mvp/presenter/${name}Presenter.kt

##activity
echo "create $controller_file"
cat << EOF > $controller_file
package com.github.typ0520.codee.ui.fragment

import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpFragment
import com.github.typ0520.codee.mvp.contract.${name}Contract
import com.github.typ0520.codee.mvp.presenter.${name}Presenter
import kotlinx.android.synthetic.main.${layout_file_prefix_name}.*

/**
 * Created by tong on ${current_date}.
 */
class ${name}Fragment : BaseMvpFragment<${name}Contract.View, ${name}Presenter>(), ${name}Contract.View {
    companion object {
        fun newInstance(): ${name}Fragment {
            val fragment = ${name}Fragment()
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.${layout_file_prefix_name}

    override fun createPresenter() = ${name}Presenter()
}
EOF

##layout file
echo "create $layout_file"
cat << EOF > $layout_file
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="@dimen/actionBarSize"
        android:background="?attr/colorPrimary"
        android:theme="@style/ThemeOverlay.AppCompat.ActionBar"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
        app:titleTextAppearance="@style/ActionbarTitle"/>

</LinearLayout>
EOF

##contact
echo "create $contact_file"
cat << EOF > $contact_file
package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter

/**
 * Created by tong on ${current_date}.
 */
interface ${name}Contract {
    interface View : IBaseView {

    }

    interface Presenter : IPresenter<View> {

    }
}
EOF


##presenter
echo "create $presenter_file"
cat << EOF  > $presenter_file
package com.github.typ0520.codee.mvp.presenter

import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.contract.${name}Contract

/**
 * Created by tong on ${current_date}.
 */
class ${name}Presenter : BasePersenter<${name}Contract.View>(), ${name}Contract.Presenter {

}
EOF