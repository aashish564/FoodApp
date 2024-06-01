package com.example.foodapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.Adapter.MenuAdapter
import com.example.foodapp.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName = listOf("Paneer Tikka","White Sauce Pasta","Chilli Potato","Malai Chaap","Mango Shake","KitKat Shake","Oreo Shake","Death By Chocolate Shake","Vanilla Shake")
        val menuItemPrice = listOf("₹250","₹200","₹100","₹110","₹100","₹100","₹90","₹150","₹90",)
        val menuImage = listOf(R.drawable.paneer_tikka,R.drawable.white_sauce_pasta,R.drawable.honey_chilli,R.drawable.dsc_1130,R.drawable.mango_milkshake,R.drawable.kitkat_shake,R.drawable.oreo_milkshake,R.drawable.death_by_chocolate,R.drawable.vanilla_shake)
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        return binding.root
    }

    companion object {


    }
}