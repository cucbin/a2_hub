package io.ioprint.djinnidemo.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.ioprint.djinnidemo.R
import io.ioprint.djinnidemo.base.fragment.AbstractBaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @author  bill.shen
 * <p>Date: 1/4/19</p>
 */
class HomeFragment : AbstractBaseFragment(),IHomeView {

    private val presenter by lazy  {
        HomePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.load()
    }

    override fun showText(content:String) {
        sampleText.text = content
    }

    companion object {
        private val TAG = "HomeFragment"
    }
}