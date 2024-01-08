package com.example.gudang

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gudang.data.DataUIState


@Composable
fun HalamanViewData(
    dataUIState: DataUIState,
    onBackButtonClicked: () -> Unit,
){
    Column(
        verticalArrangement = Arrangement.Center,

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = "id")
        Text(text = dataUIState.id)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "nama")
        Text(text = dataUIState.nama)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "jumlah")
        Text(text = dataUIState.jumlah)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "harga")
        Text(text = dataUIState.harga)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = onBackButtonClicked) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
}








