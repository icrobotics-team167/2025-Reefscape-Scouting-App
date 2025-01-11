package com.example.cotcscouting.ui.pit_scouting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PitScoutingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pit scouting fragment"
    }
    val text: LiveData<String> = _text
}