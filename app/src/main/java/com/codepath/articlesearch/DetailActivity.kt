package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.mediaAbstract)

        val DisplayArticle = intent.getSerializableExtra(ARTICLE_EXTRA) as DisplayArticle

        // Set title and abstract information for the article
        titleTextView.text = DisplayArticle.headline
        bylineTextView.text = DisplayArticle.byline
        abstractTextView.text = DisplayArticle.abstract

        // Load the media image
        Glide.with(this)
            .load(DisplayArticle.mediaImageUrl)
            .into(mediaImageView)
    }
}