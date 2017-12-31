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
controller_file=app/src/main/kotlin/cn/dp20/githubclient/ui/activity/${name}Activity.kt
layout_file_prefix_name=activity_$(class_name_2_file_name $name)
layout_file_name=$layout_file_prefix_name.xml
layout_file=app/src/main/res/layout/$layout_file_name

manifest_file=app/src/main/AndroidManifest.xml
backup_file=$manifest_file.bak
temp_file=$manifest_file.temp

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
        app:titleTextAppearance="@style/ActionbarTitle"
        app:title="${name}"
        app:navigationIcon="@mipmap/ic_arrow_back_white"/>

</LinearLayout>
EOF

##activity
echo "create $controller_file"
cat << EOF > $controller_file
package com.github.typ0520.codee.ui.activity

import android.os.Bundle
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseActivity
import kotlinx.android.synthetic.main.${layout_file_prefix_name}.*

/**
 * Created by tong on ${current_date}.
 */
class ${name}Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.${layout_file_prefix_name})
    }
}

EOF

##regist to AndroidManifest.xml
echo "auto regist activity to $manifest_file"
cp $manifest_file $backup_file

total_line_num=$(cat -n $manifest_file | tail -n1 | awk '{print $1}')
head -n $(($total_line_num-2)) $manifest_file > $temp_file

cat << EOF >> $temp_file
        <activity android:name=".ui.activity.${name}Activity"
            android:screenOrientation="portrait"
            android:theme="@style/ActivityTheme" />

    </application>
</manifest>
EOF

cat $temp_file > $manifest_file
rm $temp_file

if [ -d .git ];then
    if [ ! -f .gitignore ];then
        echo AndroidManifest.xml.bak > .gitignore
    else
         cat .gitignore | grep "AndroidManifest.xml.bak" > /dev/null 2>&1
         if [ $? == 1 ];then
            echo "AndroidManifest.xml.bak" >> .gitignore
         fi
    fi
fi