package io.ioprint.djinnidemo

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * @author  bill.shen
 * <p>Date: 1/5/19</p>
 */
class DemoApplication : Application() {

    init {
        System.loadLibrary("core")
    }

    override fun onCreate() {
        super.onCreate()
    }
}