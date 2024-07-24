package com.example.mylaporpetugas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylaporpetugas.model.ResponseDataWisataItem
import com.example.mylaporpetugas.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelWisata: ViewModel() {


    private var liveDataWisata: MutableLiveData<List<ResponseDataWisataItem>?>


    init {
        liveDataWisata = MutableLiveData()
    }

    fun getLiveDataWisata() : MutableLiveData<List<ResponseDataWisataItem>?> {
        return liveDataWisata
    }

    fun callDataWisata(){
        RetrofitClient.instance.getallpotensidesa()
            .enqueue(object :Callback<List<ResponseDataWisataItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataWisataItem>>,
                    response: Response<List<ResponseDataWisataItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataWisata.postValue(response.body())
                    }else
                        liveDataWisata.postValue(null)
                }

                override fun onFailure(call: Call<List<ResponseDataWisataItem>>, t: Throwable) {
                    liveDataWisata.postValue(null)
                }

            })
    }
}