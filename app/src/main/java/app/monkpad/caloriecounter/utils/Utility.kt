package app.monkpad.caloriecounter.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

object Utility {
    fun isConnected(context: Context): Boolean{
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java)
        val currentNetwork = connectivityManager.activeNetwork
        return currentNetwork != null
    }

    fun showToastMessage(message: String, context: Context) {
        val toast = Toast.makeText(context,
            message,
            Toast.LENGTH_LONG)
        toast.show()
    }
}