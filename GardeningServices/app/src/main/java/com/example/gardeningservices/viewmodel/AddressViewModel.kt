package com.example.gardeningservices.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gardeningservices.model.Address
import com.example.gardeningservices.network.address.AddressRepository
import com.example.gardeningservices.utilities.Resource
import kotlinx.coroutines.Dispatchers

class AddressViewModel:ViewModel() {

    private  var addressRepository = AddressRepository()

    fun getListAddress()  = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = addressRepository.getListAddress()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}