package app.monkpad.caloriecounter.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.monkpad.caloriecounter.databinding.RecyclerSingleItemBinding
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import app.monkpad.caloriecounter.interactions.CachedEntriesClickListener

/**
 *The recycler adapter to load user's cached entries. In this implementation,
 * I am simply loading all the entries in an in-memory structure
 * before processing them. With a few hundred entries, this mechanism freezes
 * the screen. A more optimal solution would be using a data util instead.
 *
 * This class as well injects the click listener callback.
 */
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
        //This is the lesser optimal solution for larger datasets
        //Using DataUtil would be a more elegant solution to prevent unnecessary reloads
        calorieEntries = items
        notifyDataSetChanged()
    }

    class HomeScreenViewHolder(private val binding: RecyclerSingleItemBinding):
            RecyclerView.ViewHolder(binding.root) {

        //We implement the binding logic here instead of in the
        // onBindViewHolder because it is fancier and easier to read.
        //Also, if we want, we can reuse this class with ease if need be.
        fun bind(item: CalorieEntry, clickListener: CachedEntriesClickListener){
            binding.clickListener = clickListener
            binding.calorieItem = item
            binding.executePendingBindings()
        }

        companion object {
            //We bring this logic here instead of in the onCreateViewHolder for the
            //same reasons as those guiding our decision for bind() above
            fun from(parent: ViewGroup): HomeScreenViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecyclerSingleItemBinding.inflate(inflater, parent, false)
                return HomeScreenViewHolder(binding)
            }
        }

    }
}