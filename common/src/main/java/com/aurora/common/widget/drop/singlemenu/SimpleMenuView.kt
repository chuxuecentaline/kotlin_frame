package com.aurora.common.widget.drop.singlemenu

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.aurora.common.decoration.CommonItemDecoration
import com.aurora.common.recycler.OnItemClickListener
import com.aurora.common.widget.drop.CommitCallback
import com.aurora.common.widget.drop.IMenuContent
import com.aurora.common.widget.drop.MenuEntity
import kotlinx.android.synthetic.main.layout_menu_simple.view.*
import androidx.recyclerview.widget.DefaultItemAnimator


/**
 * @author: aurora
 * @description: 简单的 下拉菜单
 * @date: 2019/5/30 16:24
 * @version: 2.0
 */
interface OnResultCallback {
    fun result(entity: MenuEntity)
}

class SimpleMenuView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr), IMenuContent {

    private lateinit var mAdapter: SimpleMenuAdapter
    private var mListener: CommitCallback? = null
    private var mCurrentPosition: Int = 0

    init {

        View.inflate(context, com.aurora.common.R.layout.layout_menu_simple, this)
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    fun initAdapter(callback: OnResultCallback) {
        mAdapter = SimpleMenuAdapter()
        mAdapter.setOnItemClickListener(object : OnItemClickListener<MenuEntity> {
            override fun onClick(position: Int, data: MenuEntity) {
                mAdapter.mList[mCurrentPosition].isSelected = false
                mAdapter.notifyItemChanged(mCurrentPosition)
                mAdapter.mList[position].isSelected = true
                mAdapter.notifyItemChanged(position)
                mCurrentPosition = position
                mListener?.commit()
                callback.result(data)
            }

        })
        (recyclerView.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false
        recyclerView.apply {
            addItemDecoration(CommonItemDecoration(context))
            adapter = mAdapter
        }

    }

    override fun loadData(temp: ArrayList<MenuEntity>) {
        mAdapter.setData(temp)
    }

    override fun setCommitCallback(callback: CommitCallback) {
        mListener = callback
    }

    override fun gone() {

    }


}