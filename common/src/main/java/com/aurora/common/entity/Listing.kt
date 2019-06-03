package com.aurora.common.entity

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.aurora.common.entity.po.NetworkState

/**
 * @author: aurora
 * @description: Data class that is necessary for a UI to show a listing and interact w/ the rest of the system
 * @date: 2019/5/8 15:41

 */
data class Listing<T>(
        // the LiveData of paged lists for the UI to observe
        val pagedList: LiveData<PagedList<T>>,
        // represents the network request status to show to the user
        val networkState: LiveData<NetworkState>,
        // represents the refresh status to show to the user. Separate from networkState, this
        // value is importantly only when refresh is requested.
        val refreshState: LiveData<NetworkState>?,
        // refreshes the whole data and fetches it from scratch.
        val refresh: () -> Unit,
        // retries any failed requests.
        val retry: () -> Unit)