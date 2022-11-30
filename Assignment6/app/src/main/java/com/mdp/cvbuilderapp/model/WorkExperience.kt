package com.mdp.cvbuilderapp.model

import java.io.Serializable

data class WorkExperience(val company: String,
                          val image: Int,
                          val title: String,
                          val duration: String,
                          val location: String): Serializable