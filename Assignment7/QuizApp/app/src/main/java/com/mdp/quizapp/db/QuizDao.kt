package com.mdp.quizapp.db

import androidx.room.*

@Dao
interface QuizDao {
    @Insert
    fun addQuiz(quiz: Quiz)

    @Query("SELECT * FROM QUIZ ORDER BY id ASC")
    fun getAllQuiz():List<Quiz>

    @Insert
    fun addMultipleQuiz(vararg quiz: Quiz)

    @Query("DELETE FROM QUIZ WHERE 1 = 1")
    fun deleteAllQuiz()
}