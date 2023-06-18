package com.satyamthakur.learning.shoppinglistmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.satyamthakur.learning.shoppinglistmvvm.R
import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingDatabase
import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingItem
import com.satyamthakur.learning.shoppinglistmvvm.databinding.ActivityShoppingBinding
import com.satyamthakur.learning.shoppinglistmvvm.other.ShoppingItemAdapter
import com.satyamthakur.learning.shoppinglistmvvm.repositories.ShoppingRepository
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.AddDialogListener
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.AddShoppingItemDialog
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.ShoppingViewModel
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {
    lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMain.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            AddShoppingItemDialog(this,
            object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                     viewModel.upsert(item)
                }
            }).show()
        }
    }
}