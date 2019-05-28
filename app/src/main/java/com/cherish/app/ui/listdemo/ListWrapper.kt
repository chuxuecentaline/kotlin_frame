package com.cherish.app.ui.listdemo

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.cherish.app.R
import com.cherish.common.entity.ListData
import com.cherish.common.recycler.*

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/17 15:21
 * @version: 2.0
 */


class ListWrapper : AbsWrapper<ListData>() {

    companion object {
        const val ITEM_TEXT = R.layout.item_text

    }

    interface ListVisitable : Visitable {
        fun entity(): ListData?
    }

    class Factory : AbsFactory() {

        override fun createViewHolder(viewType: Int, itemView: View, support: Support) = when (viewType) {

            ITEM_TEXT -> TextViewHolder(itemView, support)

            else -> super.createViewHolder(viewType, itemView, support)
        }
    }

    class TextViewHolder(itemView: View, support: Support) : BaseViewHolder(itemView, support) {

        private val title: AppCompatTextView = this.findView(R.id.atv_title)

        init {
            itemView.setOnClickListener { support.callBack.itemClick(itemView, adapterPosition) }
        }

        override fun bind(data: Visitable) {
            data as ListDemo
            data.entity()?.let {
                title(title, data.entity()!!.title)

            }
        }
    }


    class ListDemo(private var entity: ListData) : ListVisitable {
        override fun layoutId() = ITEM_TEXT
        override fun uid() = entity.id
        override fun entity(): ListData? = entity
        override fun getTips()=""
    }

    open class Loading : ListVisitable {
        override fun layoutId() = AdapterItemConst.ITEM_LOADING
        override fun uid() = "Loading"
        override fun entity(): ListData? = null
        override fun getTips()=""
    }

    open class Error(var errorTip: String?) : ListVisitable {
        override fun layoutId() = AdapterItemConst.ITEM_ERROR
        override fun uid() = "Error"
        override fun entity(): ListData? = null
        override fun getTips()=errorTip
    }

    open class Empty : ListVisitable {
        override fun layoutId() = AdapterItemConst.ITEM_EMPTY
        override fun uid() = "Empty"
        override fun entity(): ListData? = null
        override fun getTips()=""
    }

}
