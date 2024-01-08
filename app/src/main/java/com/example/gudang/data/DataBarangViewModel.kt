package com.example.gudang.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DataBarangViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(DataUIState())
    val stateUI: StateFlow<DataUIState> = _stateUI.asStateFlow()

    fun setData(listData: MutableList<String>){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                id = listData[0],
                nama = listData[1],
                jumlah = listData[2],
                harga = listData[3],
            )
        }
    }
}
