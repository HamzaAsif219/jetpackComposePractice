package com.example.jetpackcomposepractice.stateManagePractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class StateTestViewModel:ViewModel() {
    private val _name= MutableLiveData<String>()
    var name :LiveData<String> = _name

    private val _surname= MutableLiveData<String>()
    var surname :LiveData<String> = _surname

    fun onNameUpdate(newName:String){
        _name.value = newName
    }
    fun onSurnameUpdate(newSurname:String){
        _surname.value = newSurname
    }
}