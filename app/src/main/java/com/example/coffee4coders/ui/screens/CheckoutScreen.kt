package com.example.coffee4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffee4coders.models.Product
import com.example.coffee4coders.ui.components.*
import com.example.coffee4coders.ui.theme.Coffee4codersTheme
import com.example.coffee4coders.utilities.MockDataProvider

@Composable
fun CheckoutScreen(navController: NavController, product: Product) {

    val cities = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama",
        "La Paz, Bolivia"
    )
    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var city by remember { mutableStateOf("")}
    var message by remember { mutableStateOf<String?>(null)}
    
    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack){
                navController.navigate("detail/${product.id}")
            }
        },
        content = {
            Alert("Felicidades", message){
                navController.navigate("feed"){
                    launchSingleTop = true
                    popUpTo("feed")
                }
            }
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ProductCard(
                    product
                ) {
                }
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    CustomTextField(value = name , placeholder = "Nombre completo"){
                        name = it
                    }
                    CustomTextField(value = email , placeholder = "Correo electronico"){
                        email = it
                    }
                    CustomTextField(value = phone , placeholder = "Numero telefonico"){
                        phone = it
                    }
                    CustomTextField(value = address , placeholder = "Direccions de residencia"){
                        address = it
                    }

                    DropdownTextField(suggestions = cities, value = city, placeholder = "Ciudad"){
                        city = it
                    }

                    Column() {
                        Row {
                            Text(text ="Subtotal", style = MaterialTheme.typography.caption)
                            Text(text ="$ 35.0", style = MaterialTheme.typography.body2, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
                        }
                        Row {
                            Text(text ="Envi0", style = MaterialTheme.typography.caption)
                            Text(text ="$ 16.0", style = MaterialTheme.typography.body2, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
                        }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = "$ 45.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start
                        )
                        CustomButton(label = "Finalizar pedido") {
                            //TODo: Validar todos los campos


                            message = "Tu pedido ha sido creado Uwu"

                        }
                    }
                }
            }

        }
    )


}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    val product = MockDataProvider.getProductBy(0)
    if (product!= null){
        val navController = rememberNavController()
        Coffee4codersTheme {
            CheckoutScreen(navController, product)
        }
    }else{
        Text(text = "Error en preview")
    }
}