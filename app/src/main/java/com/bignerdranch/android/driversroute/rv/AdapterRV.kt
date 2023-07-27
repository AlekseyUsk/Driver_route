package com.bignerdranch.android.driversroute

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.driversroute.databinding.ItemCardTripBinding
import com.bignerdranch.android.driversroute.model.TripModel

class AdapterRV : ListAdapter<TripModel, AdapterRV.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCardTripBinding.bind(view)

        fun bind(item: TripModel) = with(binding) {
            turnoutItem.text = item.time
            dateItem.text = item.date
            assistantItem.text = item.assistant
            routeItem.text = item.route
            emItem.text = item.em
            endOfWorkItem.text = item.endOfWork
            workingHoursPerTripItem.text = item.working
            finalHoursItem.text = item.final_hours
        }
    }

    class Comparator : DiffUtil.ItemCallback<TripModel>() {
        override fun areItemsTheSame(oldItem: TripModel, newItem: TripModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TripModel, newItem: TripModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_trip, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}