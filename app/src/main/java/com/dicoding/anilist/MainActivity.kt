package com.dicoding.anilist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<AnimeList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)
        list.addAll(getAnimeList())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val aboutIntent = Intent(this, ProfileActivity::class.java)
                startActivity(aboutIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun getAnimeList(): ArrayList<AnimeList> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataSynopsis = resources.getStringArray(R.array.data_synopsis)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataScore = resources.getStringArray(R.array.data_score)
        val dataPopularity = resources.getStringArray(R.array.data_popularity)
        val dataRanked = resources.getStringArray(R.array.data_ranked)
        val dataEpisode = resources.getStringArray(R.array.data_episode)
        val dataAired = resources.getStringArray(R.array.data_aired)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val animeList = ArrayList<AnimeList>()
        for (i in dataTitle.indices) {
            val anime = AnimeList(dataTitle[i], dataSynopsis[i], dataPhoto.getResourceId(i, -1), dataScore[1], dataPopularity[i], dataRanked[i], dataEpisode[i], dataAired[i], dataStatus[i])
            animeList.add(anime)
        }
        return animeList
    }


    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val animeListAdapter = AnimeListAdapter(list)
        rvAnime.adapter = animeListAdapter
    }

}