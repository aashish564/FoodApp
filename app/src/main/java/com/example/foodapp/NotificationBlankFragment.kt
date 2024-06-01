 package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.Adapter.NotificationAdapter
import com.example.foodapp.databinding.FragmentHistoryBinding
import com.example.foodapp.databinding.FragmentNotificationBlankBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


 class NotificationBlankFragment : BottomSheetDialogFragment() {
     private lateinit var binding: FragmentNotificationBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment'
        binding= FragmentNotificationBlankBinding.inflate(layoutInflater,container,false)
        val notifications = listOf("Your order has been Canceled Successfully", "Order has been taken by the driver","Congrats Your Order Placed")
        val notificationImages = listOf(R.drawable.sademoji,R.drawable.icon__4_,R.drawable.group_805)
        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
        )
        return binding.root
    }

    companion object {

    }
}