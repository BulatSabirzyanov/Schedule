package com.example.schedule.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.ScheduleListItemBinding
import com.example.schedule.presentation.models.ScheduleUiListItem
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class ScheduleListAdapter(
    private val onDeleteItem: (ScheduleUiListItem) -> Unit,
    private val onItemClickListener:  (ScheduleUiListItem)  -> Unit
) : ListAdapter<ScheduleUiListItem, ScheduleViewHolder>(DiffCallback()) {

    private val itemTouchHelper: ItemTouchHelper

    init {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                onDeleteItem(getItem(position))
            }
        }
        itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ScheduleListItemBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    private class DiffCallback : DiffUtil.ItemCallback<ScheduleUiListItem>() {
        override fun areItemsTheSame(oldItem: ScheduleUiListItem, newItem: ScheduleUiListItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ScheduleUiListItem,
            newItem: ScheduleUiListItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}



