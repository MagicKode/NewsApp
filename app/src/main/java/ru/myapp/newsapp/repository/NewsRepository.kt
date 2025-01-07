package ru.myapp.newsapp.repository

import ru.myapp.newsapp.api.RetrofitInstance
import ru.myapp.newsapp.db.ArticleDataBase
import ru.myapp.newsapp.model.Article

class NewsRepository(val db: ArticleDataBase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadLines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)


    suspend fun upsert(article: Article) =
        db.getArticleDao().upsert(article)

    fun getFavouriteNews() =
        db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) =
        db.getArticleDao().deleteArticle(article)

}