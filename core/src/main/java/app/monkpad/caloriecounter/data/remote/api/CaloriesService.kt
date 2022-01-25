package app.monkpad.caloriecounter.data.remote.api

import app.monkpad.caloriecounter.core.BuildConfig
import app.monkpad.caloriecounter.data.remote.models.NetworkResponseContainer
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://api.calorieninjas.com/"

//We build our JSON parser builder
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface CaloriesService {
    @Headers("X-Api-Key: ${BuildConfig.API_KEY}")
    @GET("v1/nutrition")
    suspend fun getRemoteCalories(
        @Query("query") query: String
    ): NetworkResponseContainer

}

//Lazily expose the service because it is an expensive process.
object CaloriesApi {
    val retrofitService: CaloriesService by lazy {
        retrofit.create(CaloriesService::class.java)
    }
}