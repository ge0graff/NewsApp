package com.example.newsapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.domain.NetworkConnect
import com.example.newsapp.domain.entity.Article
import com.example.newsapp.ui.activities.MainActivity
import com.example.newsapp.ui.adapters.ForwardClick
import com.example.newsapp.ui.adapters.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(), ForwardClick, SearchView.OnQueryTextListener {

    private val viewModel by viewModel<NewsFragmentViewModel>()

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val adapter = MainAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val search = binding.searchView
        search.isSubmitButtonEnabled = true
        search.setOnQueryTextListener(this)

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



    override fun onDetails(news: Article) {
        val bundle = Bundle()
        bundle.apply {
            putString("title", news.title)
            putString("imageURL", news.urlToImage)
            putString("content", news.content)
            putString("data", news.publishedAt)
            findNavController().navigate(R.id.action_newsFragment_to_newInfoFragment, bundle)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        viewModel.searchDatabase(searchQuery).observe(this, { list ->
            list.let {
                adapter.submitList(it)
            }
        })
    }


}