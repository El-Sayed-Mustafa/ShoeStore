package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.Converter

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _shoe = MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe>
        get() = _shoe


    init {
        val initialShoeList : MutableList<Shoe> = mutableListOf()
        _shoeList.value = initialShoeList
        _shoe.value = Shoe(name = "", company = "", description = "", size = Converter.stringToDouble(""))
    }

    // Add a new Shoe to the Shoe List
    fun addShoe() {
        _shoeList.value?.add(_shoe.value!!)
        _shoe.value = Shoe("", 0.0, "", "", mutableListOf())
    }

}