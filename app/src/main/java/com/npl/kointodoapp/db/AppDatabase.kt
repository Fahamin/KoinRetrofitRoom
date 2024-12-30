package com.npl.kointodoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.npl.kointodoapp.model.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}