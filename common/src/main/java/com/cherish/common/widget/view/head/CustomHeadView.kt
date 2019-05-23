package com.cherish.common.widget.view.head

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import com.cherish.common.R
import kotlinx.android.synthetic.main.layout_detail_head.view.*
import java.util.*

/**
 * @author: cherish
 * @description: 详情页 头部轮播图
 * @date: 2019/5/23 13:30
 * @version: 2.0
 */

class CustomHeadView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

    private lateinit var mAdapter: CustomHeadAdapter

    init {
        View.inflate(context, R.layout.layout_detail_head, this)

    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mAdapter = CustomHeadAdapter(ArrayList())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = mAdapter

        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == SCROLL_STATE_IDLE) {
                    val currentPosition = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    atv_indicator.text = String.format(Locale.CHINA, "%d/%d", currentPosition+1, mAdapter.itemCount)
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

        })

        LinearSnapHelper().attachToRecyclerView(recyclerView)
    }

    /**
     * 刷新
     */
    fun setData(data: ArrayList<String>) {
        mAdapter.setData(data)
        atv_indicator.text = String.format(Locale.CHINA, "%d/%d", 1, mAdapter.itemCount)
    }

    /**
     * 更多
     */
    fun loadMoreData(data: ArrayList<String>) {
        mAdapter.loadMoreData(data)
        atv_indicator.text = String.format(Locale.CHINA, "%d/%d", 1, mAdapter.itemCount)
    }


}