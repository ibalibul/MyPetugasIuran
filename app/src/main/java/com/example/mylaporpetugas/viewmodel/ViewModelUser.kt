package com.example.mylaporpetugas.viewmodel

import androidx.lifecycle.ViewModel

class ViewModelUser : ViewModel() {

//    lateinit var liveDataUser: MutableLiveData<List<ResponseDataUserItem>?>
//    lateinit var postDataUser: MutableLiveData<ResponseDataUserItem>
//
//
//    init {
//        liveDataUser = MutableLiveData()
//        postDataUser = MutableLiveData()
//    }
//
//    fun getLiveDataUser(): MutableLiveData<List<ResponseDataUserItem>?> {
//        return liveDataUser
//    }
//
//    fun postLiveDataUser(): MutableLiveData<ResponseDataUserItem> {
//        return postDataUser
//    }
//
//
//    fun callApiUser(){
//        RetroftUser.instance.getalluser()
//            .enqueue(object : Callback<List<ResponseDataUserItem>>{
//                override fun onResponse(
//                    call: Call<List<ResponseDataUserItem>>,
//                    response: Response<List<ResponseDataUserItem>>
//                ) {
//                    if (response.isSuccessful){
//                        liveDataUser.postValue(response.body())
//                    }else
//                        liveDataUser.postValue(null)
//                }
//
//                override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
//                    liveDataUser.postValue(null)
//                }
//
//            })
//
//    }
//
////    fun postApiUser(){
//        RetroftUser.instance.addPostfilm(){
//
//        }
//    }
}