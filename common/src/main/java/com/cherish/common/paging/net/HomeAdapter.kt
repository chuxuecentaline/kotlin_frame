package com.cherish.app.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.cherish.common.R
import com.cherish.common.entity.HomeEntity
import com.cherish.common.recycler.BasePagedListAdapter
import com.cherish.common.recycler.BaseViewHolder

class HomeAdapter : BasePagedListAdapter<HomeEntity>(POST_COMPARATOR) {

    companion object {
        private val PAYLOAD_SCORE = Any()
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<HomeEntity>() {
            override fun areContentsTheSame(oldItem: HomeEntity, newItem: HomeEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areItemsTheSame(oldItem: HomeEntity, newItem: HomeEntity): Boolean =
                    oldItem == newItem

            override fun getChangePayload(oldItem: HomeEntity, newItem: HomeEntity): Any? {
                return if (sameExceptScore(oldItem, newItem)) {
                    PAYLOAD_SCORE
                } else {
                    null
                }
            }
        }

        private fun sameExceptScore(oldItem: HomeEntity, newItem: HomeEntity): Boolean {
            // DON'T do this copy in a real app, it is just convenient here for the demo :)
            // because reddit randomizes scores, we want to pass it as a payload to minimize
            // UI updates between refreshes
            return oldItem == newItem
        }
    }

    override fun onViewHolder(parent: ViewGroup): BaseViewHolder<HomeEntity> {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }



}
