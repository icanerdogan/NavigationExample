package com.icanerdogan.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.icanerdogan.jetpacknavigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var firstBinding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        firstBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return firstBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstBinding.buttonFirstFragment.setOnClickListener {
            // Argüman fonksiyonun iç kısmına alır!
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(22)
            Navigation.findNavController(it).navigate(action)

            // EDIT TEXT ile veri eklemek
            // Data Transformation için burada belirlediğimiz değeri requireArguments ile istediğimiz fragmentta alıyoruz!
            //val bundle : Bundle = bundleOf("user_input" to binding.editTextHomeFragment.text.toString())
            //it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)

        }
    }
}