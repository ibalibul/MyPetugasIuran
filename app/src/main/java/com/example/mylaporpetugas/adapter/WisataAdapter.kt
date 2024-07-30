package com.example.mylaporpetugas.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mylaporpetugas.R
import com.example.mylaporpetugas.databinding.ItemWisataBinding
import com.example.mylaporpetugas.model.ResponseDataWisataItem

class WisataAdapter(private val listWisata: List<ResponseDataWisataItem>?) : RecyclerView.Adapter<WisataAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemWisataBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):WisataAdapter.ViewHolder {
        val view = ItemWisataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Bind data to views
        holder.binding.nameBungur.text = listWisata!![position].nama
        holder.binding.DescriptionBungur.text = listWisata[position].deskrpsi
        holder.binding.lokasi.text = listWisata[position].alamat
        Glide.with(holder.itemView).load(listWisata[position].foto).into(holder.binding.imgBungur)

        holder.binding.crdItemWisata.setOnClickListener{
           var bundlee = Bundle()
            bundlee.putSerializable("dataWisata",listWisata[position])
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailWisataFragment,bundlee)

        }

    }
    override fun getItemCount(): Int {
        return listWisata!!.size
    }
}