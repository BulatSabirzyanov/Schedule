package com.example.schedule.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.example.schedule.R
import com.example.schedule.databinding.ScheduleListItemBinding
import com.example.schedule.presentation.models.ScheduleUiListItem

class ScheduleViewHolder(
    private val binding: ScheduleListItemBinding,
    private val onItemClickListener: (ScheduleUiListItem) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentItem: ScheduleUiListItem

    fun bind(item: ScheduleUiListItem) {
        currentItem = item
        with(binding) {
            root.setOnClickListener {
                onItemClickListener.invoke(item)
            }
            iVMainListItem.load(
                R.drawable.main_to_do_list_item_icon,
                Coil.imageLoader(itemView.context)
            )
            tVTitleMainListItem.text = item.title
            tVCountMainListItemItems.text = item.scheduleItemsCount.toString()
        }
    }
}