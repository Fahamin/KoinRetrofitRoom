package com.npl.kointodoapp.api

import com.npl.kointodoapp.model.Post
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun fetchPosts(): List<Post>
}