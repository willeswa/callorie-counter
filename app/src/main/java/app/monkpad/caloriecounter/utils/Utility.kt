package app.monkpad.caloriecounter.utils

import android.content.Context
import android.net.ConnectivityManager

object Utility {
    fun isConnected(context: Context): Boolean{
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java)
        val currentNetwork = connectivityManager.activeNetwork
        return currentNetwork != null
    }
}