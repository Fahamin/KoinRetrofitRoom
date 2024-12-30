package com.npl.kointodoapp.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.npl.kointodoapp.view_model.PostViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PostScreen(viewModel: PostViewModel = koinViewModel()) {
    val posts by viewModel.posts.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.loadPosts()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Posts from API") })
        }
    ) {
        LazyColumn {
            items(posts.size) { index ->
                Card(
                    modifier = Modifier.padding(8.dp),
                    elevation = 4.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = posts[index].title, style = MaterialTheme.typography.h6)
                        Text(text = posts[index].body, style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}