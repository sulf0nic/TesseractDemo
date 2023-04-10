package com.tesseractmx.tesseract.utils

data class DatosSerie(
    val fechaInicial: String,
    val fechaFinal: String,
    val valores: List<Valor>
)

data class Valor(
    val fecha: String,
    val dato: Double
)
