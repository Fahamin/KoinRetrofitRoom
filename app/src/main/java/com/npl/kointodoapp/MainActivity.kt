package com.npl.kointodoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.npl.kointodoapp.screen.PostScreen
import com.npl.kointodoapp.ui.theme.KoinTodoAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinTodoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    PostScreen()
                }
            }
        }
    }
}
