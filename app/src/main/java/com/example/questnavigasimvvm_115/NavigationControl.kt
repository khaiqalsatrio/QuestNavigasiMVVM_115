package com.example.myapplication

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.view.TampilDataView
import com.example.questnavigasimvvm_115.SiswaViewModel.SiswaViewModel
import com.example.questnavigasimvvm_115.model.JenisKelamin
import com.example.testpam3.FormulirView

enum class Halaman {
    Formulir,
    Tampildata,
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    // Memanggil StateUI dari viewModel dengan collectAsState untuk mendapatkan state UI
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        modifier = modifier,
        navController = navHost,
        startDestination = Halaman.Formulir.name
    ) {
        composable(
            route = Halaman.Formulir.name
        ) {
            val konteks = LocalContext.current
            FormulirView(
                listJK = JenisKelamin.jenisK.map { jenisKelamin ->
                    konteks.getString(jenisKelamin.stringResId)
                },
                onSubmitCliked = {
                    viewModel.setDataSiswa(it)
                    navHost.navigate(Halaman.Tampildata.name)
                }
            )
        }
        composable(route = Halaman.Tampildata.name) {
            TampilDataView(
                uiState = uiState,
                onBackButton = {
                    navHost.popBackStack()
                }
            )
        }
    }
}
