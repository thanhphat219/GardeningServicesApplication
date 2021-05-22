package com.example.gardeningservices.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


public class ServerRetrofit {

    private val IP  = "10.0.110.96"
    private val URL = "http://"+IP+":8080/serverTest/"

    private var retrofit: Retrofit? = null
    var gson = GsonBuilder()
            .setLenient()
            .create()
    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
        return retrofit
    }

}