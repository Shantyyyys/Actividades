package com.example.actividades

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Heroe(
    val nombre: String,
    val nivel: Int,
    val vida: Int
) : Parcelable