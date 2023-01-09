package com.mdp.quizapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.coroutines.CoroutineContext

@Database(
    entities = [Quiz::class],
    version = 1
)
abstract class QuizDatabase(): RoomDatabase() { // Must Inherit from RoomDatabase
    abstract fun getQuizDao() : QuizDao // Need this function to get the Dao for the Entity
    // Build RoomDB
    companion object {
        //  means that this field is immediately made visible to other threads
        @Volatile private var instance : QuizDatabase? = null
        private val LOCK = Any() // The root of the Kotlin class hierarchy. Every Kotlin class has [Any] as a superclass.
        /*  Help of ?: elvis operator check if the instance is not null return the instance,
            if it is null then synchronized block will  work, inside this also check null or not and call the function buildDatabase*/
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            // Create a instance also return the instance
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        // Function to build database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            QuizDatabase::class.java,
            "quizdatabase"
        ).build()
    }
}