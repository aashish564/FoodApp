package com.example.foodapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.CartItemBinding

class CartAdapter(private val cartItems: MutableList<String>, private val CartItemPrice:MutableList<String>, private val CartImage: MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

private val ItemQuantities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder( private val binding:CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = ItemQuantities[position]
                cartFoodName.text = cartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemquantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                        if(itemPosition != RecyclerView.NO_POSITION){
                            deleteItem(itemPosition)
                        }

                }
            }
        }
        private fun increaseQuantity(position: Int) {
            if (ItemQuantities[position] < 10) {
                ItemQuantities[position]++
                binding.cartItemquantity.text = ItemQuantities[position].toString()
            }

        }
        private fun decreaseQuantity(position: Int) {
            if (ItemQuantities[position] > 1) {
                ItemQuantities[position]--
                binding.cartItemquantity.text = ItemQuantities[position].toString()
            }

        }

        private fun deleteItem(position: Int) {
            cartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position, cartItems.size)
        }
    }

}