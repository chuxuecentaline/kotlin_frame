package com.cherish.common.widget.drop.singlemenu.category

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.recyclerview.widget.GridLayoutManager
import com.cherish.common.R
import com.cherish.common.annotation.QuitEvent
import com.cherish.common.recycler.OnItemClickListener
import com.cherish.common.rxJava.QuitTransformer
import com.cherish.common.widget.drop.MenuEntity
import com.cherish.common.widget.drop.ConvertEntity
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.layout_category_more.view.*

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/29 15:36
 * @version: 2.0
 */
class CategoryMoreView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs), ConvertEntity {

    private lateinit var mAdapter: MoreAdapter
    private var mCurrentPosition = 0

    private val subject: BehaviorSubject<Int> by lazy {
        BehaviorSubject.create<Int>()
    }

    init {

        View.inflate(context, R.layout.layout_category_more, this)
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int) : this(context, attrs)

    override fun onFinishInflate() {
        super.onFinishInflate()

        initConfig()

    }

    private fun initConfig() {
        mAdapter = MoreAdapter()
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = mAdapter
        }
        mAdapter.setOnItemClickListener(object : OnItemClickListener<MenuEntity> {
            override fun onClick(position: Int, data: MenuEntity) {
                if (mCurrentPosition != position) {
                    mAdapter.mList[mCurrentPosition].isSelected = false
                    mAdapter.notifyItemChanged(mCurrentPosition)
                    mAdapter.mList[position].isSelected = true
                    mAdapter.notifyItemChanged(position)
                    mCurrentPosition = position
                    subject.onNext(mAdapter.mList[position].id)
                }
            }

        })

    }

    /**
     * 数据重构
     */
    override fun apply(list: ArrayList<MenuEntity>) {
        mAdapter.setData(list)
    }

    /**
     * 采用响应式编程
     */
    fun create(): Observable<Int> {
        return subject
    }

    /**
     * 销毁
     */
    fun <T> bindToDestroy(): QuitTransformer<T> {
        return QuitTransformer(subject.filter { quitEvent ->
            quitEvent === QuitEvent
                    .QUIT.values
        })
    }

    override fun onDetachedFromWindow() {
        subject.onNext(QuitEvent.QUIT.values)
        super.onDetachedFromWindow()
    }


}