package com.aurora.system.ui.listdemo

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.aurora.common.api.ApiCreate
import com.aurora.common.api.ConfigApi
import com.aurora.common.entity.ListEntity
import com.aurora.common.recycler.AbsBaseAdapter
import com.aurora.common.recycler.AbsWrapper
import com.aurora.common.recycler.Support
import com.aurora.common.rxJava.ApiThrowable
import com.aurora.common.rxJava.ApplyObserverTransform
import com.aurora.common.rxJava.OnRequestNext
import com.aurora.common.ui.SmartRefreshFragment
import com.aurora.common.utils.ToastUtil.Companion.short

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/17 14:09
 * @version: 2.0
 */
class ListFragment : SmartRefreshFragment<ListWrapper.ListVisitable>() {

    override fun onItemDecoration(context: Context) = DividerItemDecoration(context, LinearLayout.VERTICAL)

    private lateinit var viewModel: ListViewModel

    init {
        page = 1
    }

    override fun setAdapter(support: Support): AbsBaseAdapter<ListWrapper.ListVisitable, AbsWrapper.BaseViewHolder> {
        return ListDemoAdapter(support)
    }

    override fun bindLiveData() {
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.getError().observe(this, Observer<String> { t ->
            t?.let { short(it) }
            error(t)
        })
    }

    override fun requestList(index: Int) {
        ApiCreate.create(ConfigApi::class.java).getList(index, 20, "999").compose(ApplyObserverTransform.compose())
                .subscribe(object : OnRequestNext<ListEntity>(compositeDisposable()) {
                    override fun success(t: ListEntity) {
                        val data = t.list
                        when (index) {
                            1 -> {
                                if (data.isNullOrEmpty()) {
                                    empty()
                                } else {

                                    val list = ArrayList<ListWrapper.ListVisitable>(data.size)
                                    for (listData in data) {
                                        val demo = ListWrapper.ListDemo(listData)
                                        list.add(demo)
                                    }
                                    refresh(list, true)

                                }
                            }
                            else -> {
                                if (data.isNullOrEmpty()) {
                                    noMore()
                                } else {
                                    val list = ArrayList<ListWrapper.ListVisitable>(data.size)
                                    data.forEach {
                                        val demo = ListWrapper.ListDemo(it)
                                        list.add(demo)
                                    }
                                    refresh(list, false)
                                }

                            }
                        }
                    }

                    override fun fail(apiThrowable: ApiThrowable) {
                        error(apiThrowable.message)
                        setIndex()
                    }

                })

    }

    override fun injectListener() {

    }

    /**
     * 点击事件
     */
    override fun onItemClick(view: View, position: Int) {
        short(position.toString())
    }

}