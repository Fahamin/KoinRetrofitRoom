package com.npl.kointodoapp.di

import androidx.room.Room
import com.npl.kointodoapp.api.PostApiService
import com.npl.kointodoapp.db.AppDatabase
import com.npl.kointodoapp.repository.PostRepository
import com.npl.kointodoapp.view_model.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(PostApiService::class.java) }

    // Room
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "app_database")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().postDao() }

    // Repository
    single { PostRepository(get(), get()) }

    // ViewModel
    viewModel { PostViewModel(get()) }
}