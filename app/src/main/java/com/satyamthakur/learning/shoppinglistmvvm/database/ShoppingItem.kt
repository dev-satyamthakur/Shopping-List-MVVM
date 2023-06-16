package com.satyamthakur.learning.shoppinglistmvvm.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String, // each will represent a column

    @ColumnInfo(name = "item_amount") // change table name from amount to item_amount
    var amount: Int
) {
    // entity should have a primary key
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}