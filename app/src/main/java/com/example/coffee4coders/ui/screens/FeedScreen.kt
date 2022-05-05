package com.example.coffee4coders.ui.screens

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffee4coders.ui.components.*
import com.example.coffee4coders.ui.theme.Coffee4codersTheme

@Composable
fun FeedScreen(navController: NavController) {

    val list = listOf<CountryISO>(
        CountryISO.BRA, CountryISO.COL, CountryISO.NIC, CountryISO.CRI
    )
    Scaffold(
        topBar = { CustomAppBar(title = "Coffee 4 Coders",) },
        content = {
            Coffee4codersTheme() {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)){
                        item {
                            Column(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                TitleText(title = "Bienvenido")
                                BodyText(body = "Lorem ipsum apliacion que ya saldra a produccion. Busca otro tipo de texto :D.")
                            }
                        }
                        items(list) { country ->
                            ProductCard("Cafe de Brasil",
                                "Cafe originario de las montañas",
                                35.0, "USD",
                                country = country){
                                navController.navigate("detail/${country.iso}"){
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        }
    )

}

@Preview(
    showBackground = true
)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}