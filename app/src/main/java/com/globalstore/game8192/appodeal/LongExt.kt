package com.globalstore.game8192.appodeal

import android.os.Handler
import android.os.Looper


fun Long.timer(onTimer: () -> Unit) {
    val handler = Handler(Looper.getMainLooper())
    val runnable = object : Runnable {
        override fun run() {
            onTimer.invoke()
            handler.postDelayed(this, this@timer)
        }
    }
    handler.postDelayed(runnable, this)
}