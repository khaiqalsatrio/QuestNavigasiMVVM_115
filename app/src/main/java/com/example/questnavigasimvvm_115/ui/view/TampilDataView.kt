package com.example.questnavigasimvvm_115.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.questnavigasimvvm_115.model.DataSiswa
import com.example.testpam3.TampilData

@Composable
fun TampilDataView(
    uiState: DataSiswa,
    onBackButton: () -> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        TampilData(parameterName = "Nama", argu = uiState.nama)
        TampilData(parameterName = "Jenis kelamin", argu = uiState.gender)
        TampilData(parameterName = "Alamat", argu = uiState.alamat)
        TampilData(parameterName = "Email", argu = uiState.email)
        TampilData(parameterName = "No Telepon", argu = uiState.notelepon)
        Button(onClick = {
            onBackButton()
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)

        ) {
            Text(text = "Kembali")
        }
    }
}