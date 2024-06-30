package com.example.mylaporpetugas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mylaporpetugas.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardProfileDesa.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileDesaFragment)
        }
        binding.accout.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }


}