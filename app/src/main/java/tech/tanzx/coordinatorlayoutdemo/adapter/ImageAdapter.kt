package tech.tanzx.coordinatorlayoutdemo.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import tech.tanzx.coordinatorlayoutdemo.R

class ImageAdapter: BaseQuickAdapter<Int, BaseViewHolder>(R.layout.item_person_image)  {

    override fun convert(holder: BaseViewHolder, item: Int) {
        val imageView: ImageView = holder.getView(R.id.iv_person_image)
        imageView.setImageResource(item)
    }
}