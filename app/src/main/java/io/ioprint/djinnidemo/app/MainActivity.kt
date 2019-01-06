package io.ioprint.djinnidemo.app

import android.os.Bundle
import io.ioprint.core.ItemList
import io.ioprint.core.SortItems
import io.ioprint.core.SortOrder
import io.ioprint.core.TextboxListener
import io.ioprint.djinnidemo.R
import io.ioprint.djinnidemo.base.activity.AbstractBaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
