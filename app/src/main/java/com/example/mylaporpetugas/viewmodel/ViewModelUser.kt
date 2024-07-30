package com.example.mylaporpetugas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylaporpetugas.data.DataUsers
import com.example.mylaporpetugas.model.ResponseDataUserItem
import com.example.mylaporpetugas.network.RetroftUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {

    private  var liveDataUser: MutableLiveData<List<ResponseDataUserItem>?>
    lateinit var postDataUser: MutableLiveData<ResponseDataUserItem?>


    init {
        liveDataUser = MutableLiveData()
        postDataUser = MutableLiveData()
    }

    fun getLiveDataUser(): MutableLiveData<List<ResponseDataUserItem>?> {
        return liveDataUser
    }

    fun postLiveDataUser(): MutableLiveData<ResponseDataUserItem?> {
        return postDataUser
    }


    fun getapiUser() {
        RetroftUser.instance.getalluser()
            .enqueue(object : Callback<List<ResponseDataUserItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataUserItem>>,
                    response: Response<List<ResponseDataUserItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataUser.postValue(response.body())
                    }else
                        liveDataUser.postValue(null)
                }

                override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
                    liveDataUser.postValue(null)
                }

            })
    }

    fun postApiUsers(name : String, email : String, password : String, notlp : Long ){
        RetroftUser.instance.addPostUser(DataUsers(name,email,password,notlp))
            .enqueue(object : Callback<ResponseDataUserItem>{
                override fun onResponse(
                    call: Call<ResponseDataUserItem>,
                    response: Response<ResponseDataUserItem>
                ) {
                    if (response.isSuccessful){
                        postDataUser.postValue(response.body())
                    }else
                        postDataUser.postValue(null)
                }

                override fun onFailure(call: Call<ResponseDataUserItem>, t: Throwable) {
                    postDataUser.postValue(null)
                }

            })
    }
}