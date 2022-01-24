package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewInfoBinding
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.ui.adapters.MainAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment() {

    private val viewModel by viewModel<NewsFragmentViewModel>()

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val adapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            newsRcView.adapter = adapter
            newsRcView.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.apply {

            newsList.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
            })
        }

    }
}