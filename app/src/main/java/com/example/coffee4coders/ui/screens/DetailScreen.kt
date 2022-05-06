package com.example.coffee4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffee4coders.ui.components.*


@Composable
fun DetailScreen(navController: NavController, countryIso: CountryISO) {

    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack){
                navController.navigate("feed"){
                    popUpTo("feed")
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = countryIso.getBackgrooundImage()),
                        contentDescription = "Background Image",
                        contentScale = ContentScale.Crop, //Recorta la imagen al tamaño de contenedor
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    TitleText(title = "Cafe de Colombia")
                    Text(
                        text = "Lorem largo muy largo, ya luego debes busacr o completar con textos String en un xml :D. Ahi ya con textos con sentido, no asi todo feo :c.",
                        style = MaterialTheme.typography.caption,
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    BodyText(body = "Lorem largo muy largo, ya luego debes busacr o completar con textos String en un xml :D. Ahi ya con textos con sentido, no asi todo feo :c.Lorem largo muy largo, ya luego debes busacr o completar con textos String en un xml :D. Ahi ya con textos con sentido, no asi todo feo :c.")

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "$ 25.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        CustomButton(label = "Continuar") {
                            navController.navigate("checkout/${countryIso.iso}"){
                                launchSingleTop = true
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    DetailScreen(navController, CountryISO.BRA)
}