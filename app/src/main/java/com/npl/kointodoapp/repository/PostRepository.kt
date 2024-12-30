package com.npl.kointodoapp.repository

import com.npl.kointodoapp.api.PostApiService
import com.npl.kointodoapp.db.PostDao
import com.npl.kointodoapp.model.Post
import kotlinx.coroutines.flow.Flow

class PostRepository(private val apiService: PostApiService, private val postDao: PostDao) {
    val posts: Flow<List<Post>> = postDao.getAllPosts()

    suspend fun refreshPosts() {
        val postsFromApi = apiService.fetchPosts()
        postDao.insertPosts(postsFromApi)
    }
}