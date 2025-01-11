package com.example.cotcscouting.ui.end_game_scouting


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EndGameScoutingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is end game scouting fragment"
    }
    val text: LiveData<String> = _text
}