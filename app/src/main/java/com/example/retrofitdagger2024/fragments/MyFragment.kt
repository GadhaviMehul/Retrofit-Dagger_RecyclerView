package com.example.retrofitdagger2024.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdagger2024.App
import com.example.retrofitdagger2024.adapter.ProductAdapter
import com.example.retrofitdagger2024.viewmodel.ProductViewModel
import com.example.retrofitdagger2024.viewmodel.ProductViewModelFactory
import com.example.retrofitdagger2024.databinding.FragmentMyBinding
import javax.inject.Inject


class MyFragment : Fragment() {

    private lateinit var binding: FragmentMyBinding
    private lateinit var viewModel: ProductViewModel
    private val adapter = ProductAdapter()

    @Inject
     lateinit var viewModelFactory: ProductViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(inflater, container, false)

        (activity?.application as App).applicationComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[ProductViewModel::class.java]

        viewModel.products.observe(viewLifecycleOwner) { productData ->

            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter = adapter
            adapter.setProductsData(productData)
        }
        return binding.root
    }
}