package com.cherish.common.widget.view.search

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatEditText
import com.cherish.common.R
import com.cherish.common.spreadfun.afterTextChanged
import com.cherish.common.utils.ToastUtil
import com.cherish.common.spreadfun.tint
import kotlinx.android.synthetic.main.layout_search.view.*


/**
 * @author: cherish
 * @description: 搜索控件
 * @date: 2019/5/27 15:20
 * @version: 2.0
 */
class SearchView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {

    private var _hint: String? = null
    private var _editColor: Int = Color.GRAY
    private var _deleteTint: Int = Color.GRAY
    private var _searchTint: Int = Color.GRAY
    private var _editSize: Float = 12.toFloat()
    private var _background: Int = R.drawable.bg_circle_white
    private var _delete: Int = R.drawable.ic_cancel_white

    private var mListener: SearchCallBack? = null

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        inflate(context, R.layout.layout_search, this)
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.SearchView, defStyleAttr, 0)

        _hint = a.getString(R.styleable.SearchView_searchHint)
        _editColor = a.getColor(R.styleable.SearchView_searchEditColor, _editColor)
        _editSize = a.getDimension(R.styleable.SearchView_searchEditSize, _editSize)
        _searchTint = a.getColor(R.styleable.SearchView_searchTint, _searchTint)
        _deleteTint = a.getColor(R.styleable.SearchView_searchDeleteTint, _deleteTint)
        _delete = a.getResourceId(R.styleable.SearchView_searchDeleteIcon, _background)
        _background = a.getResourceId(R.styleable.SearchView_searchBackground, _delete)

        a.recycle()


    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        /**
         * 搜索icon 颜色 tint
         */
        aiv_icon.tint(aiv_icon, R.drawable.ic_search_black, _searchTint)
        editStyle(aet_content)
        background(ll_root, _background)

        bindListener()

    }

    private fun bindListener() {
        aet_content.apply {
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_SEARCH ->
                        if (text.isNullOrEmpty()) {
                            ToastUtil.short(resources.getString(R.string.tips_search))
                        } else {
                            mListener?.onSearch(text.toString())
                        }
                }
                false
            }
            afterTextChanged {
                if (it.isNullOrEmpty()) {
                    mListener?.onClear()
                }
            }
        }
    }

    private fun editStyle(aet_content: AppCompatEditText?) {
        aet_content?.apply {
            setTextColor(_editColor)
            textSize = _editSize
            hint = _hint
        }
    }



    /**
     * 设置search 背景
     */
    private fun background(ll_root: LinearLayout?, @DrawableRes resId: Int) {
        ll_root?.setBackgroundResource(resId)

    }

    /**
     * 外部搜索
     */
    fun search(){
        aet_content.apply{
            if (text.isNullOrEmpty()) {
                ToastUtil.short(resources.getString(R.string.tips_search))
            } else {
                mListener?.onSearch(text.toString())
            }
        }
    }


    //搜索回调
    fun setOnSearchListener(listener: SearchCallBack) {
        mListener = listener

    }


}


