package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewInfoBinding
import com.example.newsapp.ui.activities.SplashActivityViewModel
import com.example.newsapp.ui.adapters.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewInfoFragment : Fragment() {

    private var _binding: FragmentNewInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        putText()
    }

    private fun putText(){

        val title = arguments?.getString("title")
        val imageUrl = arguments?.getString("imageURL")
        val content = arguments?.getString("content")
        val data= arguments?.getString("data")

        binding.apply {
            infoFgtTitel.text = title
            if(content.isNullOrBlank()) {
                infoFgtContent.text = getString(R.string.empty_text)
            } else {
                infoFgtContent.text = content
            }
            infoFgtData.text = data

                Glide.with(requireContext())
                    .load(imageUrl)
                    .centerCrop()
                    .error(R.drawable.ic_image_not_found)
                    .placeholder(R.drawable.ic_image_not_found)
                    .into(infoFgtImage)
        }
    }



}