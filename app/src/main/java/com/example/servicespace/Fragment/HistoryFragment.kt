package com.example.servicespace.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.servicespace.R
import com.example.servicespace.adaptar.BuyAgainAdapter
import com.example.servicespace.databinding.BuyAgainItemBinding
import com.example.servicespace.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView(){
        val buyAgainFoodName= arrayListOf("food2","ffod2","food2")
        val buyAgainFoodPrice= arrayListOf("$10","$20","$30")
        val buyAgainFoodImage= arrayListOf(R.drawable.plumber,R.drawable.plum,R.drawable.electrician)
       buyAgainAdapter=BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
       binding.BuyAgainRecyclerView.adapter=buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager=LinearLayoutManager(requireContext())
    }
    companion object {

    }
}