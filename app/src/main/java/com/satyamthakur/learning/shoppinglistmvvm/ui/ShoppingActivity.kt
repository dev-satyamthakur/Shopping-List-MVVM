package com.satyamthakur.learning.shoppinglistmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.satyamthakur.learning.shoppinglistmvvm.R
import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingDatabase
import com.satyamthakur.learning.shoppinglistmvvm.repositories.ShoppingRepository
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.ShoppingViewModel
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}