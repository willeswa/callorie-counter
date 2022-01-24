package app.monkpad.caloriecounter.framework.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import app.monkpad.caloriecounter.R
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import app.monkpad.caloriecounter.utils.Utility
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("setDouble")
fun setDouble(textView: TextView, value: Double) {
    textView.text = value.toString()
}

@BindingAdapter("loadCalorieEntries")
fun loadCalorieEntries(recyclerView: RecyclerView, list: List<CalorieEntry>?) {
    val adapter = recyclerView.adapter as HomeScreenRecyclerAdapter
    list?.let {
        adapter?.setCalorieEntries(it)
    }
}

@BindingAdapter("loadImage")
fun loadImage(image: ShapeableImageView, imageLink: String) {
    Glide.with(image.context)
        .load(imageLink)
        .centerCrop()
        .placeholder(R.drawable.ic_twotone_broken_image_24)
        .into(image)
}

@BindingAdapter("loadCalories")
fun loadCalories(textView: TextView, list: List<CalorieEntry>?) {
    if (list != null && list.isNotEmpty()) {
        textView.text = list[0].calories.toString()
    }
}

@BindingAdapter("collapsed")
fun collapsed(button: MaterialButton, collapsed: Boolean) {
    val context = button.context
    if (collapsed) {
        button.text = context.getString(R.string.text_summary)
    } else {
        button.text = context.getString(R.string.text_full_analysis)
    }
}

@BindingAdapter("offlineOrNotFound")
fun offlineOrNotFound(textView: TextView, cal: List<CalorieEntry>?) {
    val context = textView.context
    if (cal == null && Utility.isConnected(textView.context)) {
        textView.text = context.getString(R.string.error_404_message)
    } else {
        textView.text = context.resources.getString(R.string.error_message_internet)
    }
}