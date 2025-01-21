package com.example.rssreader

data class RSSItem(
    val title: String,
    val text: String,
    val type: String,
    val pubDate: String,
    val link: String,
    val author: String,
    val imageResId: Int
)
