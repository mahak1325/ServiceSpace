package com.example.servicespace.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.servicespace.databinding.CardItemBinding

@Suppress("DEPRECATION")
class CartAdaptar(private val CartItems:MutableList<String>, private val  CartItemPrice: MutableList<String>, private  var CartImage:MutableList<Int>) : RecyclerView.Adapter<CartAdaptar.CartViewHolder>(){

private val itemQuantities=IntArray(CartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding=CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder( binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
       holder.bind(position)
    }
    override fun getItemCount(): Int=CartItems.size
    inner class CartViewHolder(private val binding: CardItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodname.text = CartItems[position]
                cartitemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuantity.text = quantity.toString()

                minusbutton.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusbutton.setOnClickListener {
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
        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }
        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun deleteItem(position: Int){
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,CartItems.size)
        }
    }

}


