package com.aurora.system.ui.listdemo

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.aurora.common.recycler.AbsBaseAdapter
import com.aurora.common.recycler.AbsWrapper
import com.aurora.common.recycler.Support


/**
 * @author: aurora
 * @description: demo
 * @date: 2019/5/17 14:55
 * @version: 2.0
 */
class ListDemoAdapter(private var support: Support) : AbsBaseAdapter<ListWrapper.ListVisitable, AbsWrapper.BaseViewHolder>() {

    override fun listLoading() = ListWrapper.Loading()

    override fun listError(errorTip: String?) = ListWrapper.Error(errorTip)

    override fun listEmpty() = ListWrapper.Empty()

    private val factory = ListWrapper.Factory()


    /**
     *自动计算新老数据集的差异，并根据差异情况，自动是刷新
     */
    override fun apply(temp: ArrayList<ListWrapper.ListVisitable>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    mList[oldItemPosition].uid() === temp[newItemPosition].uid()

            override fun getOldListSize() = mList.size

            override fun getNewListSize() = temp.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    mList[oldItemPosition].uid() == temp[newItemPosition].uid()
        })
        diffResult.dispatchUpdatesTo(this)
        mList.clear()
        mList.addAll(temp)
    }

    override fun getItemViewType(position: Int) = mList[position].layoutId()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = factory.createViewHolder(viewType, inflateView(parent, viewType), support)

    override fun onBindViewHolder(holder: AbsWrapper.BaseViewHolder, position: Int) {
        holder.bind(mList[position])
    }
}