package com.example.gudang

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gudang.data.DataUIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanTambahData(
    onDataAdded: (DataUIState) -> Unit,
    onBackButtonClicked: () -> Unit,
) {
    var idBarang by remember { mutableStateOf("") }
    var namaBarang by remember { mutableStateOf("") }
    var jumlahBarang by remember { mutableStateOf("") }
    var hargaBarang by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Formulir untuk mengisi data barang
        OutlinedTextField(
            value = idBarang,
            onValueChange = { idBarang = it },
            label = { Text("ID Barang") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = namaBarang,
            onValueChange = { namaBarang = it },
            label = { Text("Nama Barang") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = jumlahBarang,
            onValueChange = { jumlahBarang = it },
            label = { Text("Jumlah Barang") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = hargaBarang,
            onValueChange = { hargaBarang = it },
            label = { Text("Harga Barang") },
            modifier = Modifier.fillMaxWidth()
        )

        // Tombol "Add Item"
        Button(
            onClick = {
                // Validasi dan tambahkan barang ke ViewModel
                if (idBarang.isNotBlank() && namaBarang.isNotBlank() && jumlahBarang.isNotBlank() && hargaBarang.isNotBlank()) {
                    onDataAdded(
                        DataUIState(
                            id = idBarang,
                            nama = namaBarang,
                            jumlah = jumlahBarang,
                            harga = hargaBarang
                        )
                    )
                } else {

                }
            }
        ) {
            Text("Add Item")
        }
        Button(onClick = onBackButtonClicked) {
            Text(text = stringResource(id = R.string.back))
        }
    }
}

