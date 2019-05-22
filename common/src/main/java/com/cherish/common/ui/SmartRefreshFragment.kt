package com.cherish.common.ui

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cherish.common.R
import com.cherish.common.picengine.glide.SimpleImageLoad
import com.cherish.common.recycler.*
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.layout_smart_refresh.*

/**
 * @author: cherish
 * @description: 下拉刷新fragment
 * @date: 2019/5/17 13:33
 * @version: 2.0
 */
abstract class SmartRefreshFragment<T>(var page: Int = 0) : BaseFragment() {
    /**
     * 初始位置
     */
    private var index = page
    private lateinit var mAdapter: AbsBaseAdapter<T, AbsWrapper.BaseViewHolder>
    private lateinit var smoothScrollHelper: SmoothScrollHelper

    override fun setLayoutId() = R.layout.layout_smart_refresh

    override fun initConfigure(view: View?) {
        smoothScrollHelper = SmoothScrollHelper(requireActivity(), recyclerView, LinearLayoutManager(requireActivity()))
        mAdapter = setAdapter(Support(SimpleImageLoad(requireActivity()), object : ListCallback {
            override fun reload() {
                mAdapter.reload()
                smartRefreshLayout.autoRefresh()
            }

            override fun itemClick(view: View, position: Int) {
                onItemClick(view, position)

            }

        }))
        recyclerView.apply {
            addItemDecoration(onItemDecoration(requireActivity()))
            adapter = mAdapter
        }

        smartRefreshLayout.apply {
            smartRefreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
                override fun onRefresh(refreshLayout: RefreshLayout) {
                    index = page
                    requestList(index)
                }

                override fun onLoadMore(refreshLayout: RefreshLayout) {
                    index++
                    requestList(index)

                }

            })

        }

        smartRefreshLayout.autoRefresh()
    }

    /**
     * 设置适配器
     */
    abstract fun setAdapter(support: Support): AbsBaseAdapter<T, AbsWrapper.BaseViewHolder>

    /**
     * 刷新
     */
    open fun refresh(list: List<T>, refresh: Boolean) {
        mAdapter.load(list, refresh)
        if (refresh) {
            finishRefresh()
        } else {
            finishMore()
        }
    }

    /**
     * 空页面
     */
    open fun empty(resId: Int = R.layout.item_empty) {
        mAdapter.empty()
    }

    /**
     * 网络错误
     */
    open fun error() {
        if (index == page) {
            mAdapter.error()
            finishRefresh()
        } else {
            finishMore()
        }

    }


    /**
     * 刷新完成
     */
    open fun finishRefresh() {
        smartRefreshLayout.finishRefresh()
    }

    /**
     * 加载完成
     */
    open fun finishMore() {
        smartRefreshLayout.finishLoadMore()
    }

    /**
     * 无更多数据
     */
    open fun noMore() {
        smartRefreshLayout.finishLoadMoreWithNoMoreData()
    }

    /**
     * 请求刷新的数据
     */
    abstract fun requestList(index: Int)

    /**
     * 点击事件的回调
     */
    abstract fun onItemClick(view: View, position: Int)

    /**
     * 获取当前的页数
     */
    fun setIndex() {
        if (index > page) {
            index--
        } else
            index = page

    }

    /**
     * 分割线
     */
    abstract fun onItemDecoration(context: Context): RecyclerView.ItemDecoration


}