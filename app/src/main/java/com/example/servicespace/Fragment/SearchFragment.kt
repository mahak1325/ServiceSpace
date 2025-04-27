package com.example.servicespace.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.servicespace.R
import com.example.servicespace.adaptar.MenuAdapter
import com.example.servicespace.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter:MenuAdapter
    private val originalMenuFoodName= listOf("Wallpaper installation","Plumbing services","AC repair","Refrigerator repair","TV repair","Metal painting","Exterior painting","Sofa cleaning","Wallpaper installation","Plumbing services","AC repair","Refrigerator repair","TV repair","Metal painting","Exterior painting","Sofa cleaning")
    private val originalMenuItemPrice= listOf("$4","$5","$7","$4","$4","$5","$7","$4","$4","$5","$7","$4","$4","$5","$7","$4")
    private val originalMenuImage= listOf(
        R.drawable.plumber,
        R.drawable.plumber,R.drawable.plumber,
        R.drawable.plumber,R.drawable.plumber,
        R.drawable.plumber,R.drawable.plumber,
        R.drawable.plumber, R.drawable.plumber,
        R.drawable.plumber,R.drawable.plumber,
        R.drawable.plumber,R.drawable.plumber,
        R.drawable.plumber,R.drawable.plumber,
        R.drawable.plumber,)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSearchBinding.inflate(inflater,container,false)
        adapter=MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage)
        binding.menuRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        //setup for search view
        setupSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()


        originalMenuFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query,ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }

        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}