package com.example.mylaporpetugas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        val currentItem = listWisata?.get(position)

        // Bind data to views
        holder.binding.nameBungur.text = currentItem?.nama
        holder.binding.DescriptionBungur.text = currentItem?.deskrpsi
        holder.binding.lokasi.text = currentItem?.alamat

        // Load image using Glide (example)
        // Uncomment this if you have Glide configured and want to load images
//        Glide.with(holder.itemView.context)
//            .load(currentItem?.foto)
//            .into(holder.binding.imgBungur)

    }
    override fun getItemCount(): Int {
        return listWisata?.size ?:0
    }
}