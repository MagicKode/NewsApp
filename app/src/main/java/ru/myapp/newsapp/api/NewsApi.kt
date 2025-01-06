package ru.myapp.newsapp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.myapp.newsapp.model.NewsResponse
import ru.myapp.newsapp.util.Constants.Companion.API_KEY
import java.util.Locale.IsoCountryCode

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getHeadLines(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

}