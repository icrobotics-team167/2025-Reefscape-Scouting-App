package com.example.cotcscouting.ui.auto_scouting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AutoScoutingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is auto scouting fragment"
    }
    val text: LiveData<String> = _text
}