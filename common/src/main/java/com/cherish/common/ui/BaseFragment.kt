package com.cherish.common.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cherish.common.widget.dialog.LottieDialogFragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {
    private val lottieDialogFragment: LottieDialogFragment by lazy {
        LottieDialogFragment()
    }
    /**
     * 订阅管理
     */
    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }
    private lateinit var mViewModel: BaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(setLayoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindLiveData()
        initConfigure(view)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(requireActivity()).get(BaseViewModel::class.java)

    }

    /**
     * 管理订阅
     */
    protected fun compositeDisposable() = compositeDisposable

    /**
     * 设置布局
     */
    @LayoutRes
    abstract fun setLayoutId(): Int

    /**
     * 初始化配置
     */
    protected abstract fun initConfigure(view: View)

    /**
     * 绑定life
     */
    abstract fun bindLiveData()

    override fun onDestroyView() {
        compositeDisposable.clear()
        super.onDestroyView()
    }

    /**
     * 无参
     */
    fun launchActivity(clazz: Class<out Activity>) {
        val intent = Intent(activity, clazz)
        startActivity(intent)

    }

    /**
     * 有参
     */
    fun launchActivity(clazz: Class<out Activity>, bundle: Bundle) {
        val intent = Intent(activity, clazz)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    /**
     *  获取 Drawable 资源
     */
    fun getDrawableCompat(res: Int): Drawable? {
        return context?.let { ContextCompat.getDrawable(it, res) }
    }

    /**
     * 软键盘开启、关闭
     */
    protected fun controlKeyboard(isShow: Boolean) {
        try {

            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    ?: return
            val currentFocus = activity?.currentFocus
            if (isShow) {
                if (currentFocus != null) {
                    //有焦点打开
                    imm.showSoftInput(currentFocus, 0)
                } else {
                    //无焦点打开
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                }
            } else {
                if (currentFocus != null) {
                    //有焦点关闭
                    imm.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
                } else {
                    //无焦点关闭
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 是否还在执行
     */
    protected fun isLoading() = lottieDialogFragment.isVisible

    /**
     * cancelable 点击外部是否消失
     */
    protected fun loadingDialog(cancelable: Boolean = true) {
        lottieDialogFragment.apply {
            isCancelable = cancelable
            show(this@BaseFragment.requireFragmentManager(), LottieDialogFragment.TAG)
        }
    }

    fun dismissDialog() {
        lottieDialogFragment.dismiss()
    }

}
