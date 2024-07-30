package com.example.mylaporpetugas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylaporpetugas.model.ResponseDataPengaduanItem
import com.example.mylaporpetugas.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelPengaduan: ViewModel() {

    private var liveDataPengaduan : MutableLiveData<List<ResponseDataPengaduanItem>?>

    init {
        liveDataPengaduan = MutableLiveData()
    }

    fun getLiveDataPengaduan() : MutableLiveData<List<ResponseDataPengaduanItem>?> {
        return liveDataPengaduan
    }

    fun getCallDataPengaduan(){
        RetrofitClient.instance.getallPengaduan()
            .enqueue(object : Callback<List<ResponseDataPengaduanItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataPengaduanItem>>,
                    response: Response<List<ResponseDataPengaduanItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataPengaduan.postValue(response.body())
                    }else
                        liveDataPengaduan.postValue(null)
                }

                override fun onFailure(call: Call<List<ResponseDataPengaduanItem>>, t: Throwable) {
                    liveDataPengaduan.postValue(null)
                }

            })
    }
}