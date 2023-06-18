package com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.et_amount
import kotlinx.android.synthetic.main.dialog_add_shopping_item.et_name
import kotlinx.android.synthetic.main.dialog_add_shopping_item.tv_add
import kotlinx.android.synthetic.main.dialog_add_shopping_item.tv_cancel

class AddShoppingItemDialog(
    context: Context,
    var addDialogListener: AddDialogListener
): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tv_add.setOnClickListener {
            val name = et_name.text.toString()
            val amount = et_amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tv_cancel.setOnClickListener {
            cancel()
        }
    }

}