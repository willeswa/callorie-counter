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

@BindingAdapter("updateButton")
fun updateButton(button: MaterialButton, loading:Boolean){
    if(loading){
        button.text = "Calculating"
    } else {
        button.text = "Calculate Calories"
    }
}

@BindingAdapter("loadCalories")
fun loadCalories(textView: TextView, list: List<CalorieEntry>?){
    if(list != null && list.isNotEmpty()){
        textView.text = list[0].calories.toString()
    }
}

@BindingAdapter("collapsed")
fun collapsed(button: MaterialButton, collapsed: Boolean){
    if(collapsed){
        button.text = "Calories Summary"
    } else {
        button.text = "See detailed breakdown"
    }
}

@BindingAdapter("offlineOrNotFound")
fun offlineOrNotFound(textView: TextView, cal: List<CalorieEntry>?){
   if(cal == null && Utility.isConnected(textView.context)){
       textView.text = "I did not find a food by that name, please try another one."
   } else {
       textView.text = "You seem offline. Please connect to the internet first."
   }
}