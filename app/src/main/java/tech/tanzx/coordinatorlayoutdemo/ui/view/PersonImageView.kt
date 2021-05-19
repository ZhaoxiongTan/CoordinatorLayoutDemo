package tech.tanzx.coordinatorlayoutdemo.ui.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import tech.tanzx.coordinatorlayoutdemo.adapter.ImageAdapter
import tech.tanzx.coordinatorlayoutdemo.databinding.ViewPersonImageBinding

class PersonImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr)  {

    private val binding = ViewPersonImageBinding.inflate(LayoutInflater.from(context), this, true)

    private val imageAdapter = ImageAdapter()

    init {
        binding.recyclerImages.isNestedScrollingEnabled = false
        binding.recyclerImages.layoutManager = GridLayoutManager(context, 3)
        binding.recyclerImages.adapter = imageAdapter
    }

    fun setImages(images: List<Int>) {

        Log.d(TAG, "setImages: $images")
        imageAdapter.setList(images)
    }

    companion object {
        private const val TAG = "PersonImageView"
    }
}