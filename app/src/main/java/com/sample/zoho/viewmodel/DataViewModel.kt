package com.sample.zoho.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.zoho.data.repository.UserListRepository
import com.sample.zoho.data.responsemodels.UserResponseModel
import com.sample.zoho.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(var repository: UserListRepository):ViewModel() {

    var _data = MutableLiveData<Resource<UserResponseModel>>()
    val data:LiveData<Resource<UserResponseModel>>
    get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO){

            _data.postValue(Resource.loading(null))

            try {
                val response = repository.getData()

                _data.postValue(Resource.success(response.body()))
            }catch (e:Exception){
                _data.postValue(Resource.error(e.localizedMessage,null))
            }




        }
    }

}