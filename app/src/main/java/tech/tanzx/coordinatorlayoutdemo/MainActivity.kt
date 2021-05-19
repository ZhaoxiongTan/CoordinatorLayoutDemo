package tech.tanzx.coordinatorlayoutdemo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.BarUtils
import com.google.android.material.appbar.AppBarLayout
import tech.tanzx.coordinatorlayoutdemo.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)
        BarUtils.setStatusBarLightMode(this, true)

        //toolbar 填充状态栏空白空间
        val statusBarHeight = BarUtils.getStatusBarHeight()
        binding.toolbar.post {
            val newHeight = binding.toolbar.height + statusBarHeight
            val layoutParams = binding.toolbar.layoutParams as FrameLayout.LayoutParams
            layoutParams.height = newHeight
            binding.toolbar.layoutParams = layoutParams

            val containerLayoutParams =
                binding.containerToolbarContent.layoutParams as FrameLayout.LayoutParams
            containerLayoutParams.topMargin = statusBarHeight
            binding.containerToolbarContent.layoutParams = containerLayoutParams
        }

        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            Log.d(TAG, "initView: verticalOffset = $verticalOffset, appBarLayout.totalScrollRange = ${appBarLayout.totalScrollRange}")

            //透明度渐变来切换折叠展开的效果
            val toolBarAlpha = abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange.toFloat()
            val profileAlpha = 1f - toolBarAlpha * 0.5f
            binding.ivAvatar.alpha = toolBarAlpha
            binding.ivUsername.alpha = toolBarAlpha
            binding.ivToolbarBackground.alpha = toolBarAlpha
            binding.ivProfileCard.alpha = profileAlpha

        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}