package com.example.cotcscouting.ui.match_scouting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MatchScoutingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is match scouting fragment"
    }
    val text: LiveData<String> = _text
}