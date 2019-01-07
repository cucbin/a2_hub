package io.ioprint.djinnidemo.app

import io.ioprint.core.ItemList
import io.ioprint.core.SortItems
import io.ioprint.core.SortOrder
import io.ioprint.core.TextboxListener

/**
 * @author  bill.shen
 * <p>Date: 1/4/19</p>
 */
class HomePresenter(private val view: IHomeView):TextboxListener {

    private var sortItems: SortItems? = null

    init {
        sortItems = SortItems.createWithListener(this)
    }

    fun load() {
        val itemList = ItemList(arrayListOf("123", "654", "789"));
        sortItems?.sort(SortOrder.ASCENDING, itemList);
    }

    override fun update(items: ItemList?) {
        val content = "the order:".plus(items.toString())
        view.showText(content)
    }

    companion object {
        private val TAG = "HomePresenter"
    }
}