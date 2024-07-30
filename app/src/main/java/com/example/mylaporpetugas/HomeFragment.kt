package com.example.mylaporpetugas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylaporpetugas.adapter.PengaduanAdapter
import com.example.mylaporpetugas.adapter.WisataAdapter
import com.example.mylaporpetugas.databinding.FragmentHomeBinding
import com.example.mylaporpetugas.viewmodel.ViewModelPengaduan
import com.example.mylaporpetugas.viewmodel.ViewModelWisata


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var adapter: WisataAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDataPengaduan()
        showDataWisataa()

        binding.cardProfileDesa.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_profileDesaFragment)
        }
        binding.accout.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }

//    fun showDataWisata(){
//        RetrofitClient.instance.getallpotensidesa()
//            .enqueue(object : Callback<List<ResponseDataWisataItem>>{
//                override fun onResponse(
//                    call: Call<List<ResponseDataWisataItem>>,
//                    response: Response<List<ResponseDataWisataItem>>
//                ) {
//                    if (response.isSuccessful){
//                        binding.rvWisata.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
//                        binding.rvWisata.adapter = WisataAdapter(response.body()!!)
//                    }else
//                        Toast.makeText(context, "Load Data Failed", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onFailure(call: Call<List<ResponseDataWisataItem>>, t: Throwable) {
//                    Toast.makeText(context, "Data Wrong", Toast.LENGTH_SHORT).show()
//                }
//
//            })
//    }

    fun showDataWisataa() {
        val viewModel = ViewModelProvider(this).get(ViewModelWisata::class.java)
        viewModel.getCallDataWisata()
        viewModel.getLiveDataWisata().observe(viewLifecycleOwner, Observer {
            if (it != null)
                binding.rvWisata.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.rvWisata.adapter = WisataAdapter(it)

        })
    }

    fun showDataPengaduan() {
        val viewModel = ViewModelProvider(this).get(ViewModelPengaduan::class.java)
        viewModel.getCallDataPengaduan()
        viewModel.getLiveDataPengaduan().observe(viewLifecycleOwner, Observer {
            if (it != null)
                binding.rvBerita.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                binding.rvBerita.adapter = PengaduanAdapter(it)
        })
    }



}