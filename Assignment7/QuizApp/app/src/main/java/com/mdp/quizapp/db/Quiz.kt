package com.mdp.quizapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Quiz (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    var answer: String,
    ) : Serializable {}