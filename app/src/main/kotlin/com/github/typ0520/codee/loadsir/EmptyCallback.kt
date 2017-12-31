package com.github.typ0520.codee.loadsir

import com.github.typ0520.codee.R
import com.kingja.loadsir.callback.Callback

/**
 * Created by tong on 2017/12/25.
 */
class EmptyCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }
}