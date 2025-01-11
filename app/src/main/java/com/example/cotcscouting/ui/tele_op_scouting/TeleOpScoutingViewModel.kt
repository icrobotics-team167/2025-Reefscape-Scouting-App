package com.example.cotcscouting.ui.tele_op_scouting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TeleOpScoutingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is TeleOp scouting fragment"
    }
    val text: LiveData<String> = _text
}