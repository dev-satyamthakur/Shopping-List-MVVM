package com.satyamthakur.learning.shoppinglistmvvm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
This is an interface
that has all the methods
for accessing database.
It is must for Room
**/

@Dao
interface ShoppingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem): Unit

    @Delete
    suspend fun delete(item: ShoppingItem): Unit

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>

}