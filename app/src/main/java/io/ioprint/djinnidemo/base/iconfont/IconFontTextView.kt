package io.ioprint.djinnidemo.base.iconfont

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * @author  bill.shen
 * <p>Date: 1/6/19</p>
 */
class IconFontTextView : AppCompatTextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        if (!isInEditMode){
            typeface = Typeface.createFromAsset(context.assets, "iconfont/iconfont.ttf")
        }
    }

}