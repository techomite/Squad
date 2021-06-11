package com.andromite.api.data

import com.andromite.api.data.services.FootballAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object FootballClient {

    private var authToken: String? = null


    private val interceptor = Interceptor { chain ->
        var req = chain.request()

        authToken.let {
            req = req.newBuilder()
                .header("x-rapidapi-key", "la8v5yuRndmsh1cjo64UAftTppBvp1hzW7FjsnahQengis4nSa")
                .header("x-rapidapi-host", "football98.p.rapidapi.com")
                .build()
        }

        chain.proceed(req)
    }

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("https://football98.p.rapidapi.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))

    val api: FootballAPI = retrofit
        .client(OkHttpClient().newBuilder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(2, TimeUnit.SECONDS)
            .addInterceptor(interceptor).build())
        .build()
        .create(FootballAPI::class.java)
}