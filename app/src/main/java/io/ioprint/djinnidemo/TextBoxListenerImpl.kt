package io.ioprint.djinnidemo

import android.widget.TextView
import io.ioprint.core.ItemList
import io.ioprint.core.TextboxListener

/**
 * @author  bill.shen
 * <p>Date: 10/31/18</p>
 */
class TextBoxListenerImpl(private var textView:TextView):TextboxListener{

    override fun update(items: ItemList) {
        val content = "the order:".plus(items.toString())
//        for (item in items.items){
//            content + item.toString() +";"
//        }
        textView.setText(content)
    }
}
