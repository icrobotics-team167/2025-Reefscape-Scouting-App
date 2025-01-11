package com.example.cotcscouting.ui.blue_alliance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlueAllianceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is blue alliance fragment"
    }
    val text: LiveData<String> = _text
}