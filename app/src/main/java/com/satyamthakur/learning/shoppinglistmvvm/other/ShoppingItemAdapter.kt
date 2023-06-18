package com.satyamthakur.learning.shoppinglistmvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satyamthakur.learning.shoppinglistmvvm.R
import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingItem
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.iv_delete
import kotlinx.android.synthetic.main.shopping_item.view.iv_minus
import kotlinx.android.synthetic.main.shopping_item.view.iv_plus
import kotlinx.android.synthetic.main.shopping_item.view.tv_amount
import kotlinx.android.synthetic.main.shopping_item.view.tv_name

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position];
        holder.itemView.tv_name.text = curShoppingItem.name
        holder.itemView.tv_amount.text = curShoppingItem.amount.toString()

        holder.itemView.iv_delete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.iv_plus.setOnClickListener {
            curShoppingItem.amount += 1
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.iv_minus.setOnClickListener {
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount -= 1
                viewModel.upsert(curShoppingItem)
            }
        }

    }
}