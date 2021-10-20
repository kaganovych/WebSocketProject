package com.example.testproject.ui.grocery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testproject.R
import com.example.testproject.databinding.FragmentGroceryBinding
import com.example.testproject.grocery
import com.example.testproject.space
import com.example.testproject.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GroceryFragment: Fragment() {

    private lateinit var binding: FragmentGroceryBinding

    private val viewModel by viewModel<GroceryViewModel>()
    private val sharedViewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initDataBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.groceries.observe(viewLifecycleOwner) { list ->
            binding.rv.withModels {
                list.forEach { item ->
                    grocery {
                        id("${item.name}${item.color}${item.weight}")
                        name(item.name)
                        color(item.color)
                        weight(item.weight)
                    }

                    space {
                        id("space${item.name}${item.color}${item.weight}")
                    }
                }
            }
        }

        sharedViewModel.isConnected.observe(viewLifecycleOwner) { isConnected ->
            binding.btnConnect.text = if (isConnected) getString(R.string.disconnect) else getString(R.string.connect)
        }

        binding.btnConnect.setOnClickListener {
            sharedViewModel.toggleConnection()
        }
    }

    private fun initDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_grocery, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
    }
}