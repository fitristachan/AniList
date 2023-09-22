package com.dicoding.anilist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeListAdapter(private val animeList: ArrayList<AnimeList>): RecyclerView.Adapter<AnimeListAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvSynopsis: TextView = itemView.findViewById(R.id.tv_item_synopsis)
        val shareAction = itemView.findViewById<ImageButton>(R.id.action_share)
//        val clickAction = itemView.findViewById<ImageButton>(R.id.action_click)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_anime, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = animeList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val animeItem = animeList[position]
        holder.imgPhoto.setImageResource(animeItem.photo)
        holder.tvTitle.text = animeItem.title
        holder.tvSynopsis.text = limitWords(animeItem.synopsis, 20)  + "...."

        holder.shareAction.setOnClickListener {
            shareContent(holder.itemView.context, holder.tvTitle.text as String + ": " + holder.tvSynopsis.text as String)
        }

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_anime", animeItem)
            holder.itemView.context.startActivity(intentDetail)
        }
    }


    private fun shareContent(context: Context, content: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, content)

        val chooser = Intent.createChooser(intent, "Share via")
        if (chooser.resolveActivity(context.packageManager) != null) {
            context.startActivity(chooser)
        }
    }

    private fun limitWords(text: String, limit: Int): String {
        val words = text.trim().split("\\s+".toRegex())
        val limitedWords = words.take(limit)
        return limitedWords.joinToString(" ")
    }

}