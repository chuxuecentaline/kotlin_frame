package com.cherish.common.widget.drop.tab

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cherish.common.recycler.OnItemClickListener
import com.cherish.common.recycler.OnMenuItemClickListener

/**
 * @author: cherish
 * @description: 菜单Tab
 * @date: 2019/5/30 13:56
 * @version: 2.0
 */
class MenuTabView constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
        RecyclerView(context, attrs, defStyle) {
    private lateinit var mAdapter: MenuTabAdapter

    constructor(context: Context) : this(context, null)

    private var mCurrentPosition = 0

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    /**
     *初始化
     */
    fun initAdapter(size: Int, callback: OnMenuItemClickListener) {

        mAdapter = MenuTabAdapter()
        mAdapter.setOnItemClickListener(object : OnItemClickListener<TabMenuEntity> {
            override fun onClick(position: Int, data: TabMenuEntity) {
                mAdapter.mList[mCurrentPosition].isSelect = false
                mAdapter.notifyItemChanged(mCurrentPosition)
                mAdapter.mList[position].isSelect = true
                mAdapter.notifyItemChanged(position)
                mCurrentPosition = position
                callback.onclick(position)

            }

        })
        layoutManager = GridLayoutManager(context, size)
        adapter = mAdapter

    }

    /**
     * 数据
     */
    fun applyTitles(list: ArrayList<TabMenuEntity>) {
        mAdapter.setData(list)
    }

    /**
     * 重置
     */
    fun applyTitle(position :Int,title:String) {
        mAdapter.mList[position].title=title
        mAdapter.notifyItemChanged(position)
    }

}