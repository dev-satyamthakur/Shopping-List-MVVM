package com.satyamthakur.learning.shoppinglistmvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satyamthakur.learning.shoppinglistmvvm.R
import com.satyamthakur.learning.shoppinglistmvvm.database.ShoppingItem
import com.satyamthakur.learning.shoppinglistmvvm.databinding.ShoppingItemBinding
import com.satyamthakur.learning.shoppinglistmvvm.ui.shoppinglist.ShoppingViewModel

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
        val binding: ShoppingItemBinding = ShoppingItemBinding.bind(holder.itemView)
        val curShoppingItem = items[position];
        binding.tvName.text = curShoppingItem.name
        binding.tvAmount.text = curShoppingItem.amount.toString()

        binding.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        binding.ivPlus.setOnClickListener {
            curShoppingItem.amount += 1
            viewModel.upsert(curShoppingItem)
        }

        binding.ivMinus.setOnClickListener {
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount -= 1
                viewModel.upsert(curShoppingItem)
            }
        }

    }
}