package app.monkpad.caloriecounter.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.monkpad.caloriecounter.databinding.RecyclerSingleItemBinding
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import app.monkpad.caloriecounter.interactions.CachedEntriesClickListener

class HomeScreenRecyclerAdapter(private val clickListener: CachedEntriesClickListener):
        RecyclerView.Adapter<HomeScreenRecyclerAdapter.HomeScreenViewHolder>() {

    private var calorieEntries = listOf<CalorieEntry>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeScreenViewHolder.from(parent)

    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        val entry = calorieEntries[position]
        holder.bind(entry, clickListener)
    }

    override fun getItemCount() =
        calorieEntries.size

    fun setCalorieEntries(items: List<CalorieEntry>){
        calorieEntries = items
        notifyDataSetChanged()
    }

    class HomeScreenViewHolder(private val binding: RecyclerSingleItemBinding):
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CalorieEntry, clickListener: CachedEntriesClickListener){
            binding.clickListener = clickListener
            binding.calorieItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): HomeScreenViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecyclerSingleItemBinding.inflate(inflater, parent, false)
                return HomeScreenViewHolder(binding)
            }
        }

    }
}