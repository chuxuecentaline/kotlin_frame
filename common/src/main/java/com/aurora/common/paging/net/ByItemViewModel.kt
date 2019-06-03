package com.aurora.system.Home

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aurora.common.ui.BaseViewModel

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/8 16:01
 * @version: 2.0
 */
 class ByItemViewModel : BaseViewModel() {

    val accounts = LivePagedListBuilder(ByItemDataSourceFactory(compositeDisposable()),
            PagedList.Config.Builder()
                    .setPageSize(30)
                    .setEnablePlaceholders(false).build()).build()
}