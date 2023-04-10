package com.tesseractmx.tesseract.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class TimeSeries (
     val idSerie: String,
     val titulo: String,
     val datos: Map<String, Double>
)

val retrofit = Retrofit.Builder()
    .baseUrl("https://www.banxico.org.mx/SieAPIRest/service/v1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

//val banxicoApi = retrofit.create(BanxicoApi::class.java)


