package com.example.gudang

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gudang.data.DataUIState
import com.example.gudang.login.AuthViewModel
import com.example.gudang.login.HalamanLogin


enum class PengelolaHalaman {
    Home,
    Login,
    Sepatu,
    AddDataBarang,
    ViewDataBarang


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GudangAppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,

        navigationIcon = {
            if (bisaNavigasiBack){
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GudangApp(

    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            GudangAppBar(bisaNavigasiBack = false, navigasiUp = { /*TODO*/ })

        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Login.name)
                    })
            }
            composable(route = PengelolaHalaman.Login.name) {
                HalamanLogin(
                    onLoginButtonClicked = { username, password ->
                        if (authViewModel.authenticate(username, password)) {
                            navController.navigate(PengelolaHalaman.Sepatu.name)
                        } else {

                        }
                    }
                )
            }
            composable(route = PengelolaHalaman.Sepatu.name) {
                HalamanUtama(
                    onAddDataClicked = {
                        navController.navigate(PengelolaHalaman.AddDataBarang.name)
                    },
                    onViewDataClicked = {
                        navController.navigate(PengelolaHalaman.ViewDataBarang.name)
                    },
                    onLogoutButton = {navController}
                )
            }
            composable(route = PengelolaHalaman.AddDataBarang.name) {
                HalamanTambahData(
                    onDataAdded = {
                    }, onBackButtonClicked = {navController.navigate(PengelolaHalaman.Sepatu.name)}
                )
            }
            composable(route = PengelolaHalaman.ViewDataBarang.name) {
                HalamanViewData(
                    onBackButtonClicked = {navController.navigate(PengelolaHalaman.Sepatu.name)}, dataUIState = DataUIState()
                )
            }

        }
    }
}


