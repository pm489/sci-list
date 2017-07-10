package com.example.shada.articlefeed

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_article_list.*
import kotlinx.android.synthetic.main.activity_article.view.*

class article_list : Activity() {

    val articles_list = listOf(Article("Organic molecules spotted in star-forming disk", "Life’s building blocks seen around young would-be star.", "https://media.springernature.com/w700/magazine-springer-cms/rest/v1/content/13276882/data"), Article("The resourcefulness of the Rapa Nui people", "Easter Island soil reveals careful cultivation.", "https://media.springernature.com/w700/magazine-springer-cms/rest/v1/content/13076708/data"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_list)
        val articleAdapter = ArticleAdapter(this, articles_list)
        articles.adapter = articleAdapter
    }
}

class ArticleAdapter(val myContext: Context, val articles: List<Article>) : ArrayAdapter<Article>(myContext, 0, articles) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(myContext).inflate(R.layout.activity_article, parent, false);
        } else view = convertView
        val article = articles[position]

        view.article_title.text = article.title
        view.article_description.text = article.description
        Picasso.with(myContext).load(article.image).into(view.article_image)
        return view
    }
}

data class Article(val title: String, val description: String, val image: String)