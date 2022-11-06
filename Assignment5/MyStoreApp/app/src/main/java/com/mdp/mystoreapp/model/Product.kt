package com.mdp.mystoreapp.model

import java.io.Serializable

data class Product(
    val title: String,
    val price: Double,
    val color: String,
    val image: Int,
    val itemId: String,
    val desc: String
): Serializable