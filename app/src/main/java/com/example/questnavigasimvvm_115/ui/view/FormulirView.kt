package com.example.questnavigasimvvm_115.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@Preview(showBackground = true)
@Composable
fun FormulirView(modifier: Modifier = Modifier,
                 listJK: List<String>,
                 onSubmitCliked: (MutableList<String>) -> Unit
){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(nama, gender, alamat, email, notelepon)

    Column(
        modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = {
                Text(text = "nama")
            },
            placeholder = {
                Text(text = "isi nama anda")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row (modifier = Modifier.fillMaxWidth()){
            listJK.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender, onClick = {
                            gender = selectedGender
                        })
                    Text(text = selectedGender)
                }
            }
        }