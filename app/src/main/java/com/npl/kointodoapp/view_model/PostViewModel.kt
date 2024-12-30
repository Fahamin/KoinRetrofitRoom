package com.npl.kointodoapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.npl.kointodoapp.model.Post
import com.npl.kointodoapp.repository.PostRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    val posts: StateFlow<List<Post>> = repository.posts.stateIn(
        scope = viewModelScope,
        started = kotlinx.coroutines.flow.SharingStarted.Lazily,
        initialValue = emptyList()
    )

    fun loadPosts() {
        viewModelScope.launch {
            repository.refreshPosts()
        }
    }
}