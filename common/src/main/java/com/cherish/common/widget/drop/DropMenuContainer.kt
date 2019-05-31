package com.cherish.common.widget.drop

import android.content.Context
import android.util.AttributeSet
import android.util.SparseIntArray
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import com.cherish.common.R
import java.util.ArrayList

/**
 * @author: cherish
 * @description: 下载菜单容器
 * @date: 2019/5/30 11:49
 * @version: 2.0
 */
interface OnHideCallback {
    fun hide()
}

class DropMenuContainer(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr), CommitCallback {

    private val mMenuContentViews = ArrayList<IMenuContent>(4)
    private val mSparseIntArray = SparseIntArray(4)
    private var mCurrentPosition = -1//当前打开的位置
    private var openMenu: Boolean = false//菜单状态
    private lateinit var mCallBack:OnHideCallback

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        visibility = View.GONE
        setBackgroundResource(R.color.colorDropMenuMask)
        setOnClickListener {
            cancel()

        }
    }

    /**
     * 操作
     */
    fun operator(position: Int) {
        when (visibility) {
            View.GONE -> {
                mCurrentPosition = mSparseIntArray.get(position)
                inAnimal()
                visibility = View.VISIBLE
                getChildAt(mCurrentPosition).apply {
                    animation = AnimationUtils.loadAnimation(context, R.anim.menu_child_in)
                    visibility = View.VISIBLE
                }
            }
            else -> {
                when (mSparseIntArray.get(position)) {
                    mCurrentPosition -> {
                        close()
                    }
                    else -> {
                        val showPosition = mSparseIntArray.get(position)
                        when {
                            mCurrentPosition < showPosition -> {
                                getChildAt(mCurrentPosition).apply {
                                    animation = AnimationUtils.loadAnimation(context, R.anim.out_left_child_drop_menu)
                                    visibility = View.GONE
                                }
                                getChildAt(showPosition).apply {
                                    animation = AnimationUtils.loadAnimation(context, R.anim.in_left_child_drop_menu)
                                    visibility = View.VISIBLE
                                }
                            }
                            else -> {
                                getChildAt(mCurrentPosition).apply {
                                    animation = AnimationUtils.loadAnimation(context, R.anim.out_right_child_drop_menu)
                                    visibility = View.GONE
                                }
                                getChildAt(showPosition).apply {
                                    animation = AnimationUtils.loadAnimation(context, R.anim.in_right_child_drop_menu)
                                    visibility = View.VISIBLE
                                }
                            }
                        }
                        mMenuContentViews[mCurrentPosition].gone()
                        mCurrentPosition = showPosition
                    }
                }
            }
        }
    }

    /**
     * 添加子view
     */
    fun addChild(position: Int, child: View) {
        mSparseIntArray.put(position, childCount)
        child.visibility = View.GONE
        addView(child, position)
        if (child is IMenuContent) {
            child.setCommitCallback(this)
            mMenuContentViews.add(position, child)
        }

    }

    /**
     * 外部消失
     */
    private fun cancel() {
        commit()
    }

    /**
     * 进入动画
     */
    private fun inAnimal() {
        animation = AnimationUtils.loadAnimation(context, R.anim.in_drop_menu)
    }

    /**
     * 退出动画
     */
    private fun outAnimal() {
        animation = AnimationUtils.loadAnimation(context, R.anim.out_drop_menu)
    }

    private fun close() {
        outAnimal()
        visibility = View.GONE
        if (mCurrentPosition in 0..childCount) {
            mMenuContentViews[mCurrentPosition].gone()
            getChildAt(mCurrentPosition)?.apply {
                animation = AnimationUtils.loadAnimation(context, R.anim.out_drop_menu)
                visibility = View.GONE
            }
        }
        mCurrentPosition = -1
        mCallBack.hide()
    }


    /**
     * 提交
     */
    override fun commit() {
        close()

    }

    /**
     * 隐藏软键盘
     */
    fun hideKeyboard(callback: OnHideCallback){
        mCallBack=callback
    }


}