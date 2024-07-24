package com.example.mylaporpetugas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mylaporpetugas.databinding.FragmentHelpMeBinding


class HelpMeFragment : Fragment() {

    lateinit var binding : FragmentHelpMeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHelpMeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBack.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_helpMeFragment_to_profileFragment)
        }
    }

}