package com.example.servicespace.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.servicespace.CongratsBottomSheet
import com.example.servicespace.PayOutActivity
import com.example.servicespace.R
import com.example.servicespace.adaptar.CartAdaptar
import com.example.servicespace.databinding.CardItemBinding
import com.example.servicespace.databinding.FragmentCartBinding


class CartFragment : Fragment() {
   private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)
        val cartFoodName= listOf("Wallpaper installation","Plumbing services","AC repair","Refrigerator repair","TV repair","Metal painting","Exterior painting","Sofa cleaning")
        val cartItemPrice= listOf("$4","$5","$7","$4","$5","$7","$4","$5")
        val cartImage= listOf(
            R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,)
        val adapter=CartAdaptar(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter
        binding.proceedButton.setOnClickListener{
            val intent=Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    companion object {


    }
}