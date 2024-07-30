package com.example.mylaporpetugas.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mylaporpetugas.R
import com.example.mylaporpetugas.databinding.ItemPengaduanBinding
import com.example.mylaporpetugas.model.ResponseDataPengaduanItem

class PengaduanAdapter(private val listpengaduan: List<ResponseDataPengaduanItem>?) : RecyclerView.Adapter<PengaduanAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemPengaduanBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPengaduanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.namePlace.text = listpengaduan!![position].judul
        holder.binding.lokasi.text = listpengaduan[position].lokasi
        holder.binding.Descriptionplace.text = listpengaduan[position].deskripsi
        holder.binding.notlp.text = listpengaduan[position].notlp.toString()
        holder.binding.tglPengaduan.text = listpengaduan[position].tanggal
        Glide.with(holder.itemView).load(listpengaduan[position].foto).into(holder.binding.imgPlace)

        holder.binding.cvItemBerita.setOnClickListener{
            var bundleee = Bundle()
            bundleee.putSerializable("dataPengaduan",listpengaduan[position])
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailPengaduanFragment,bundleee)
        }
    }

    override fun getItemCount(): Int {
        return listpengaduan?.size ?:0
    }
}