package com.example.coffee4coders.utilities

import com.example.coffee4coders.models.Product

class MockDataProvider {
    companion object{
        fun listOfProducts(): List<Product>{
            return listOf(
                Product(
                    0,
                    "Café de Colombia",
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    55.0,
                    "USD",
                    "COL"
                ),
                Product(
                    1,
                    "Café de Brasil",
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    40.0,
                    "USD",
                    "BRA"
                ),
                Product(
                    2,
                    "Café de Costa Ríca",
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    35.0,
                    "USD",
                    "CRI"
                ),
                Product(
                    3,
                    "Café de Nicaragua",
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    50.0,
                    "USD",
                    "NIC"
                )
            )
        }

        fun getProductBy(id: Int): Product? {
            val list = MockDataProvider.listOfProducts()
            val product = list.find { it.id == id }
            return product
        }

        fun listOfCities(): List<String>{
            return listOf(
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
        }

    }
}