package tech.tanzx.coordinatorlayoutdemo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
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

//        binding.collapsingToolbarLayout.set

        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0){
                Log.d(TAG, "initView: Collapsed")

                if(binding.ivAvatar.visibility == View.GONE) {
                    binding.ivAvatar.setImageDrawable(ColorDrawable(Color.parseColor("#051255")))
                    binding.ivAvatar.visibility = View.VISIBLE
                    binding.tvExpand.visibility = View.GONE
                }

            } else {
                Log.d(TAG, "initView: Expanded")
                binding.ivAvatar.visibility = View.GONE
                binding.tvExpand.visibility = View.VISIBLE
            }
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}