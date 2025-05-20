package com.example.servicespace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.servicespace.adaptar.MenuAdapter
import com.example.servicespace.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener{
            dismiss()
        }

        val menuFoodName= listOf("Wallpaper installation","Plumbing services","AC repair","Refrigerator repair","TV repair","Metal painting","Exterior painting","Sofa cleaning","Wallpaper installation","Plumbing services","AC repair","Refrigerator repair","TV repair","Metal painting","Exterior painting","Sofa cleaning")
        val menuItemPrice= listOf("$4","$5","$7","$4","$4","$5","$7","$4","$4","$5","$7","$4","$4","$5","$7","$4")
        val menuImage= listOf(
            R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber, R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,R.drawable.plumber,
            R.drawable.plumber,)
        val adapter= MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        return binding.root
    }


    companion object {

    }
}