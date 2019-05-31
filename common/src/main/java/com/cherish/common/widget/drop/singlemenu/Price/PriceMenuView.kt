package com.cherish.common.widget.drop.singlemenu.Price

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import com.cherish.common.R
import com.cherish.common.widget.drop.CommitCallback
import com.cherish.common.widget.drop.IMenuContent
import com.cherish.common.widget.drop.MenuEntity
import com.cherish.common.widget.drop.singlemenu.OnResultCallback
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.layout_price.view.*
import java.util.concurrent.TimeUnit

/**
 * @author: cherish
 * @description: 价格
 * @date: 2019/5/31 10:41
 * @version: 2.0
 */

interface OnPriceResultCallback {
    fun result(minPrice: String, maxPrice: String)
}

class PriceMenuView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs), IMenuContent {

    private lateinit var mCallback: CommitCallback
    private lateinit var mListener: OnPriceResultCallback

    init {

        View.inflate(context, R.layout.layout_price, this)
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int) : this(context, attrs)

    fun initConfig() {
        atv_reset.clicks().throttleFirst(1, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    edt_pre_money.setText("")
                    edt_last_money.setText("")
                }
        atv_finish.clicks().throttleFirst(2, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    mListener.result(edt_pre_money.text.toString(), edt_last_money.text.toString())
                    mCallback.commit()
                }
    }

    override fun loadData(temp: ArrayList<MenuEntity>) {

    }

    override fun setCommitCallback(callback: CommitCallback) {
        mCallback = callback
    }

    fun setOnResultCallback(listener: OnPriceResultCallback) {
        mListener = listener
    }

    override fun gone() {

    }


}