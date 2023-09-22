package com.dicoding.anilist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailSynopsis = findViewById<TextView>(R.id.tv_detail_synopsis)
        val tvDetailTitle = findViewById<TextView>(R.id.tv_detail_title)
        val imgDetailPhoto = findViewById<ImageView>(R.id.img_detail_photo)
        val tvDetailEpisode = findViewById<TextView>(R.id.tv_detail_episode)
        val tvDetailAired = findViewById<TextView>(R.id.tv_detail_aired)
        val tvDetailStatus = findViewById<TextView>(R.id.tv_detail_status)
        val tvDetailRanked = findViewById<TextView>(R.id.tv_detail_ranked)
        val tvDetailPopularity = findViewById<TextView>(R.id.tv_detail_popularity)
        val tvDetailScore = findViewById<TextView>(R.id.tv_detail_score)

        val animeList = intent.getParcelableExtra<AnimeList>("key_anime")

        if (animeList != null) {
            imgDetailPhoto.setImageResource(animeList.photo)
            tvDetailTitle.text = animeList.title
            tvDetailEpisode.text = animeList.episode
            tvDetailAired.text = animeList.aired
            tvDetailStatus.text = animeList.status
            tvDetailScore.text = animeList.score
            tvDetailRanked.text = animeList.ranked
            tvDetailPopularity.text = animeList.popularity
            tvDetailSynopsis.text = animeList.synopsis

        }
    }
}
