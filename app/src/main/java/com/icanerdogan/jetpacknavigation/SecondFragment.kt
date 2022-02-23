package com.icanerdogan.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.icanerdogan.jetpacknavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var secondBinding: FragmentSecondBinding
    private  var secondAge = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        secondBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        return secondBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // VERİ ALMA
        // First Fragment içinden gelen argüman Eğerki boş değilse!
        arguments?.let {
            secondAge = SecondFragmentArgs.fromBundle(it).age
            println(secondAge)
        }

        secondBinding.buttonSecondFragment.setOnClickListener {
            val action  = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            //Navigation.findNavController(it).navigate(action)
            it.findNavController().navigate(action)

            // EDIT TEXT ile veri almak
            //val input : String? = requireArguments().getString("user_input")
            //binding.textViewSecondFragment.text = input

        }

    }
}