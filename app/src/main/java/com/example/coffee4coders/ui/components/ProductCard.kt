package com.example.coffee4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee4coders.R
import com.example.coffee4coders.models.Product
import com.example.coffee4coders.ui.theme.Coffee4codersTheme
import com.example.coffee4coders.ui.theme.PlatziBlue
import com.example.coffee4coders.ui.theme.PlatziGreen
import com.example.coffee4coders.utilities.MockDataProvider


enum class CountryISO(val iso: String){
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgrooundImage(): Int{
        when(this){
            COL -> return R.drawable.co
            BRA -> return R.drawable.br
            CRI -> return R.drawable.ri
            NIC -> return R.drawable.ni

        }
    }

    fun getCountryImage(): Int{
        when(this){
            COL -> return R.drawable.flagco
            BRA -> return R.drawable.flagbr
            CRI -> return R.drawable.flagri
            NIC -> return R.drawable.flagni
        }
    }

    fun getSurfaceColor(): Color {
        when(this){
            COL, NIC -> return PlatziBlue
            BRA, CRI -> return PlatziGreen

        }
    }
}

typealias SelectionAction = () -> Unit

@Composable
fun ProductCard(product: Product, selected: SelectionAction ) {

    val country = CountryISO.valueOf(product.countryISO) ?: CountryISO.COL
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                selected()
            }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Image(
            painter = painterResource(id = country.getBackgrooundImage()),
            contentDescription = "Colombian coffee")
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.getSurfaceColor().copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = product.name, style = MaterialTheme.typography.h4)
                Text(text = product.summary, style = MaterialTheme.typography.body1 )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = country.getCountryImage()),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp))
                        Text(
                            text = "$${product.price} ${product.currency}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4)
                    }

                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProductCardPreview() {
    val product = MockDataProvider.getProductBy(0)
    if (product!= null){
        Coffee4codersTheme() {
            ProductCard(product = product
            ){}
        }
    }else{
        Text(text = "Error en preview")
    }

}