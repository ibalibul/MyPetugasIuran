package com.example.mylaporpetugas.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.mylaporpetugas.R
import com.example.mylaporpetugas.databinding.FragmentDetailWisataBinding
import com.example.mylaporpetugas.databinding.FragmentWisataBinding
import com.example.mylaporpetugas.model.ResponseDataWisataItem


class DetailWisataFragment : Fragment() {


    lateinit var binding : FragmentDetailWisataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailWisataBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var dataWisata = arguments?.getSerializable("dataWisata") as ResponseDataWisataItem
        binding.txtMonomentNasionalDetail.text = dataWisata.nama
        binding.lokasiWisata.text = dataWisata.alamat
        binding.txtDescripsiWisata.text = dataWisata.deskrpsi
        Glide.with(this).load(dataWisata.foto).into(binding.imgDetailWisata)

        binding.btnBackDetailWisata.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailWisataFragment_to_homeFragment)
        }

    }



}