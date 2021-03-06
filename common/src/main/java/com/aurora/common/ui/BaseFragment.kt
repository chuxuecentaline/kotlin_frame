package com.aurora.common.ui

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.aurora.common.widget.dialog.LottieDialogFragment
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
        injectListener()
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

    /**
     * 事件监听
     */
    abstract fun injectListener()

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

    /**
     * 取消对话框
     */
    fun dismissDialog() {
        lottieDialogFragment.dismiss()
    }

    /**
     * 销毁订阅
     */
    override fun onDestroyView() {
        compositeDisposable.clear()
        super.onDestroyView()
    }

}
