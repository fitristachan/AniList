package com.dicoding.anilist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimeList(
    var title: String,
    var synopsis: String,
    var photo: Int,
    var score: String,
    var popularity: String,
    var ranked: String,
    var episode: String,
    var aired: String,
    var status: String

) : Parcelable
