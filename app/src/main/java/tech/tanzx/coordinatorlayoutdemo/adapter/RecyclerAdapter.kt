package tech.tanzx.coordinatorlayoutdemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import tech.tanzx.coordinatorlayoutdemo.R
import tech.tanzx.coordinatorlayoutdemo.entity.Person
import tech.tanzx.coordinatorlayoutdemo.ui.view.PersonImageView

class RecyclerAdapter: BaseQuickAdapter<Person, BaseViewHolder>(R.layout.item_person_info)  {
    override fun convert(holder: BaseViewHolder, item: Person) {

        holder.setText(R.id.tv_name, item.name)
        val imageView: PersonImageView = holder.getView(R.id.view_person_image)
        imageView.setImages(item.images)

    }
}