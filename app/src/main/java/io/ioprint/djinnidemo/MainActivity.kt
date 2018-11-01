package io.ioprint.djinnidemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.ioprint.core.ItemList
import io.ioprint.core.SortItems
import io.ioprint.core.SortOrder
import io.ioprint.core.TextboxListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var textBoxListener:TextboxListener
    private lateinit var sortItems: SortItems

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textBoxListener = TextBoxListenerImpl(textView = sample_text )
        sortItems = SortItems.createWithListener(textBoxListener)
        this.sort(SortOrder.ASCENDING);
    }

    fun sort(order:SortOrder) {
        val itemList:ItemList  = ItemList(arrayListOf("123","654","789"));
        sortItems.sort(order, itemList);
    }

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("core")
        }
    }
}
