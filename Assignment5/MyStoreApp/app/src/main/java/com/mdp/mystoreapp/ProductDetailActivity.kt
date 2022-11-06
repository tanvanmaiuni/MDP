package com.mdp.mystoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mdp.mystoreapp.model.Product
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        if(intent.hasExtra("product")){
            var product = intent.getSerializableExtra("product") as Product
            txtTitle.text = product.title
            txtColor.text = "Color: ${product.color}"
            txtWalmartId.text = "Walmart #: ${product.itemId}"
            txtDesc.text = product.desc
            imgView.setImageResource(product.image)
        }
    }
}