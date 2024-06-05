package com.example.foodapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.Adapter.MenuAdapter
import androidx.appcompat.widget.SearchView
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentSearchBinding
//import com.google.android.material.search.SearchView


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var  adapter: MenuAdapter
    private var originalMenuFoodName = listOf("Paneer Tikka","White Sauce Pasta","Chilli Potato","Malai Chaap","Mango Shake","KitKat Shake","Oreo Shake","Death By Chocolate Shake","Vanilla Shake")
    private val originalMenuItemPrice = listOf("₹250","₹200","₹100","₹110","₹100","₹100","₹90","₹150","₹90",)
    private val originalMenuImage = listOf(R.drawable.paneer_tikka,R.drawable.white_sauce_pasta,R.drawable.honey_chilli,R.drawable.dsc_1130,R.drawable.mango_milkshake,R.drawable.kitkat_shake,R.drawable.oreo_milkshake,R.drawable.death_by_chocolate,R.drawable.vanilla_shake)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filterdMenuFoodName = mutableListOf<String>()
    private val filterdMenuItemPrice = mutableListOf<String>()
    private val filterdMenuImage = mutableListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter= MenuAdapter(filterdMenuFoodName,filterdMenuItemPrice,filterdMenuImage,requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        // setup for search view
        setupSearchView()
        // show all menu items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterdMenuFoodName.clear()
        filterdMenuItemPrice.clear()
        filterdMenuImage.clear()

        filterdMenuFoodName.addAll(originalMenuFoodName)
        filterdMenuItemPrice.addAll(originalMenuItemPrice)
        filterdMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()

    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(/* listener = */ object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
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
        filterdMenuFoodName.clear()
        filterdMenuItemPrice.clear()
        filterdMenuImage.clear()

        originalMenuFoodName.forEachIndexed{ index, foodName ->
            if (foodName.contains(query.toString(), ignoreCase = true)){
                filterdMenuFoodName.add(foodName)
                filterdMenuItemPrice.add(originalMenuItemPrice[index])
                filterdMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()

    }

    companion object {

    }
}

