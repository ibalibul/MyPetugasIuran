package com.example.mylaporpetugas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.mylaporpetugas.databinding.FragmentDetailPengaduanBinding
import com.example.mylaporpetugas.model.ResponseDataPengaduanItem


class DetailPengaduanFragment : Fragment() {

    lateinit var binding : FragmentDetailPengaduanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailPengaduanBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dataPengaduan = arguments?.getSerializable("dataPengaduan") as ResponseDataPengaduanItem
        binding.txtMonomentNasionalDetail.text = dataPengaduan.judul
        binding.lokasiBerita.text = dataPengaduan.lokasi
        binding.txtDescripsiBerita.text = dataPengaduan.deskripsi
        binding.notlpnPengadu.text = dataPengaduan.notlp.toString()
        binding.tanggalPengadu.text = dataPengaduan.tanggal
        Glide.with(this).load(dataPengaduan.foto).into(binding.imgDetailPengaduan)

        binding.btnBackDetailPengaduan.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailPengaduanFragment_to_homeFragment)
        }

    }


}