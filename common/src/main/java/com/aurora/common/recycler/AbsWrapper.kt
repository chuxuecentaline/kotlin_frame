package com.aurora.common.recycler

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.aurora.common.picengine.glide.SimpleImageLoad
import kotlinx.android.synthetic.main.item_error.view.*

/**
 * @author: aurora
 * @description: 装饰基类 包含 空页面 网络错误页面 预加载页面 顶层函数
 * @date: 2019/5/17 16:11
 * @version: 2.0
 */

open class Support(val imageLoad: SimpleImageLoad<String>, val callBack: ListCallback)

open interface Visitable {
    fun layoutId(): Int
    fun uid(): String
    fun getTips():String?
}

open class AbsWrapper<R> {

    abstract class BaseViewHolder(itemView: View, support: Support) :
            IViewHolder<Visitable, Support>(itemView, support) {

        protected fun image(view: ImageView, url: String?) {
            support.imageLoad.load(view, url)
        }

        protected fun title(view: AppCompatTextView, msg: String) {
            view.text = msg
        }


    }

    abstract class AbsFactory : ItemFactory<BaseViewHolder, Support> {

        override fun createViewHolder(viewType: Int, itemView: View, support: Support) = when (viewType) {

            AdapterItemConst.ITEM_LOADING -> LoadingViewHolder(itemView, support)
            AdapterItemConst.ITEM_ERROR -> ErrorViewHolder(itemView, support)

            else -> EmptyViewHolder(itemView, support)
        }
    }

    /**
     * 预加载
     */
    class LoadingViewHolder(itemView: View, support: Support) : BaseViewHolder(itemView, support) {
        override fun bind(data: Visitable) {
            //ignore
        }
    }

    /**
     * 网络错误
     */
    class ErrorViewHolder(itemView: View, support: Support) : BaseViewHolder(itemView, support) {
        override fun bind(data: Visitable) {
            itemView.setOnClickListener {
                support.callBack.reload()
            }
            itemView.atv_tips.text=data.getTips()
        }
    }

    /**
     * 空页面
     */
    class EmptyViewHolder(itemView: View, support: Support) : BaseViewHolder(itemView, support) {
        override fun bind(data: Visitable) {
            //ignore
        }
    }


}