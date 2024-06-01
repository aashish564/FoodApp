package com.example.foodapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.foodapp.Adapter.CartAdapter
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)


        val cartFoodName = listOf("Paneer Tikka","White Sauce Pasta","Chilli Potato","Malai Chaap","Mango Shake")
        val cartItemPrice = listOf("₹250","₹200","₹100","₹110","₹100")
        val cartImage = listOf(R.drawable.paneer_tikka,R.drawable.white_sauce_pasta,R.drawable.honey_chilli,R.drawable.dsc_1130,R.drawable.mango_milkshake)
        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter
        return binding.root
    }

    companion object {

    }
}