package com.example.servicespace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.servicespace.adaptar.NotificationAdapter
import com.example.servicespace.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notification_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        val notifications= listOf("The service you booked is cancelled","Order has been taken by service provider","congrats your service provider is on the way")
        val notificationImages= listOf(R.drawable.sad,R.drawable.help,R.drawable.serviceprovider)
        val adapter=NotificationAdapter(ArrayList(notifications), ArrayList(notificationImages))
        binding.notificationRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter=adapter
        return binding.root
    }

    companion object {

    }
}