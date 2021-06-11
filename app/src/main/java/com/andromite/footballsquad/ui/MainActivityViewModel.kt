package com.andromite.footballsquad.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.api.data.entities.Scorer
import com.andromite.api.data.entities.Squad
import com.andromite.footballsquad.repository.MainRepository
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {



    val _squads = MutableLiveData<List<Squad>>()
    val _scorer = MutableLiveData<List<Scorer>>()

    var squads : LiveData<List<Squad>> = _squads
    var scorer : LiveData<List<Scorer>> = _scorer


    fun getSquads(league:String){
        Log.e("12345","league from view model: "+league)
        viewModelScope.launch {
            MainRepository.getSquads(league).let {
                _squads.value = it
            }
        }
    }

    fun getScoorer(league:String){
        viewModelScope.launch {
            MainRepository.getScorer(league).let {
                _scorer.value = it
            }
        }
    }



}