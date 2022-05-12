package com.example.coffee4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffee4coders.ui.components.CountryISO
import com.example.coffee4coders.ui.screens.CheckoutScreen
import com.example.coffee4coders.ui.screens.DetailScreen
import com.example.coffee4coders.ui.screens.FeedScreen
import com.example.coffee4coders.ui.theme.Coffee4codersTheme
import com.example.coffee4coders.utilities.MockDataProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    Coffee4codersTheme() {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed" ){
                composable(route = "feed"){
                    FeedScreen(navController)
                }
                composable(route = "detail/{productId}"){ backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("productId") ?: "COL"
                    val productId = productIdString.toInt()
                    val product = MockDataProvider.getProductBy(productId)
                    DetailScreen(navController, product!!)
                }
                composable(route = "checkout/{productId}"){ backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("productId") ?: "COL"
                    val productId = productIdString.toInt()
                    val product = MockDataProvider.getProductBy(productId)

                    CheckoutScreen(navController, product!! )
                }
            }
        }
    }
}