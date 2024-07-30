package com.example.mylaporpetugas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mylaporpetugas.databinding.FragmentRegisterBinding
import com.example.mylaporpetugas.viewmodel.ViewModelUser


class RegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.btnRegister.setOnClickListener{
           var name = binding.FullName.text.toString()
           var email = binding.EmailSignUp.text.toString()
           var password = binding.adminPasswordSignUp.text.toString()
           var notlp = binding.edNoTlp.text.toString().toLong()
           postDataUsers(name,email,password,notlp)
       }

    }

    fun postDataUsers(name: String, email: String, password: String, notlp: Long) {
        val viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.postApiUsers(name, email, password, notlp)
        viewModel.postLiveDataUser().observe(viewLifecycleOwner, Observer{
            if (it != null) {
                Toast.makeText(context, "Add Data Succesfull", Toast.LENGTH_SHORT).show()
                Log.d("Add", it.toString())
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_registerFragment_to_loginFragment)
            }
        })
    }

}