package com.satyamthakur.learning.shoppinglistmvvm.repositories

import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingDatabase
import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    suspend fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}