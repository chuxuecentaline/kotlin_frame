package com.cherish.common.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: cherish
 * @description:recyclerView 基类
 * @date: 2019/5/17 14:44
 * @version: 2.0
 */
abstract class AbsBaseAdapter<E, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>(), IAdapter<E> {
    val mList = ArrayList<E>()
    private val loading = listLoading()
    private val error = listError()
    private val empty = listEmpty()

    abstract fun listLoading(): E

    abstract fun listError(): E

    abstract fun listEmpty(): E

    init {
        mList.add(loading)
    }

    /**
     * 加载数据
     */
    override fun load(temp: List<E>, refresh: Boolean) {
        val newList = ArrayList<E>(temp)
        if (!refresh) {
            newList.addAll(0, mList)
        }
        apply(newList)
    }

    /**
     * 重试
     */
    override fun reload() {
        val temp = ArrayList<E>(1)
        temp.add(loading)
        apply(temp)
    }

    /**
     * 空页面
     */
    override fun empty() {
        val temp = ArrayList<E>(1)
        temp.add(empty)
        apply(temp)
    }

    /**
     * 网络错误
     */
    override fun error() {
        val temp = ArrayList<E>(1)
        temp.add(error)
        apply(temp)
    }

    abstract fun apply(list: ArrayList<E>)

    override fun getItemCount() = mList.size

    protected fun inflateView(parent: ViewGroup, viewType: Int) =
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)!!
}