package com.example.gudang

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HalamanUtama(
    onAddDataClicked: () -> Unit,
    onViewDataClicked: () -> Unit,
    onLogoutButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardButton(
            text = "Add Data Barang",
            onClick = onAddDataClicked
        )

        Spacer(modifier = Modifier.height(16.dp))

        CardButton(
            text = "View Data Barang",
            onClick = onViewDataClicked
        )
        CardButton(
            text = "LogOut",
            onClick = onLogoutButton
        )
    }
}

@Composable
fun CardButton(text: String, onClick: () -> Unit) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp)
        )
    }
}








