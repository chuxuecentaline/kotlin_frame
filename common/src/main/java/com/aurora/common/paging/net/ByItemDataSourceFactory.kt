package com.aurora.system.Home

import androidx.paging.DataSource
import com.aurora.common.entity.HomeEntity
import io.reactivex.disposables.CompositeDisposable

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/8 16:07
 * @version: 2.0
 */
class ByItemDataSourceFactory(private val compositeDisposable: CompositeDisposable) : DataSource.Factory<Long, HomeEntity>() {
    override fun create(): DataSource<Long, HomeEntity> = ByItemDataSource(compositeDisposable)
}