package app.monkpad.caloriecounter.presentation.homescreen.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import app.monkpad.caloriecounter.R
import app.monkpad.caloriecounter.domain.models.CalorieEntry
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("setDouble")
fun setDouble(textView: TextView, value: Double){
    textView.text = value.toString()
}


@BindingAdapter("loadCalorieEntries")
fun loadCalorieEntries(recyclerView: RecyclerView, list: List<CalorieEntry>?){
    val adapter = recyclerView.adapter as HomeScreenRecyclerAdapter
    list?.let {
        adapter?.setCalorieEntries(it)
    }
}

@BindingAdapter("loadImage")
fun loadImage(image: ShapeableImageView, imageLink: String){
    Glide.with(image.context)
        .load(imageLink)
        .centerCrop()
        .placeholder(R.drawable.ic_twotone_broken_image_24)
        .into(image)
}