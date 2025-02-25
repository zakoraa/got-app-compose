package com.raflis.game_of_thrones.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class House(
    val name: EnumHouse,
    val image: String,
):Parcelable