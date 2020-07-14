package io.ioprint.djinnidemo.app

import android.os.Bundle
import io.ioprint.djinnidemo.R
import io.ioprint.djinnidemo.base.activity.AbstractBaseActivity

class HomeActivity : AbstractBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
