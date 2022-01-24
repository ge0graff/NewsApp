package com.example.newsapp.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.domain.entity.Article

@Database(
    entities = [Article::class],
    version = 9,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class NewsDataBase: RoomDatabase() {
    abstract fun NewsDataBaseDao(): NewsDataBaseDao

    companion object {

        @Volatile
        private var INSTANCE: NewsDataBase? = null

        fun getInstance(context: Context): NewsDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDataBase::class.java,
                        "news_dataBase"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}