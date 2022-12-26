package com.example.binlistapp

import StringArg
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.binlistapp.databinding.NewPostFragmentBinding
import com.example.binlistapp.util.AndroidUtils
import com.example.binlistapp.viewmodel.CardInfoViewModel

class NewPostFragment : Fragment() {

//    companion object {
//        var Bundle.textArg: String? by StringArg
//    }

    private val viewModel: CardInfoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NewPostFragmentBinding.inflate(
            inflater,
            container,
            false
        )

//        arguments?.textArg
//            ?.let(binding.edit::setText)

        binding.ok.setOnClickListener {
            viewModel.loadInfo(binding.edit.text.toString())
            AndroidUtils.hideKeyboard(requireView())
            findNavController().navigateUp()

        }

        return binding.root
    }
}