package com.example.coffee4coders.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffee4coders.ui.components.CustomTextField
import com.example.coffee4coders.ui.theme.Coffee4codersTheme

@Composable
fun CheckoutScreen() {
    var name by remember { mutableStateOf("")}
    CustomTextField(value = name, placeholder = "Nombre"){
        name = it
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    Coffee4codersTheme {
        CheckoutScreen()
    }
}