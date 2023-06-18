package com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist

import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}