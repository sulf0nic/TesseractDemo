package com.tesseractmx.tesseract.utils

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BanxicoService {
    @GET("series/{idSerie}/datos/{fechaInicial}/{fechaFinal}")
    suspend fun obtenerDatosSerie(
        @Path("idSerie") idSerie: String,
        @Path("fechaInicial") fechaInicial: String,
        @Path("fechaFinal") fechaFinal: String,
        @Query("token") token: String
    ): Response<DatosSerie>
}