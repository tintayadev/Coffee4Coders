package com.example.coffee4coders.ui.components


import android.widget.ImageButton
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffee4coders.ui.theme.Coffee4codersTheme

typealias NavigationAction = () -> Unit

@Composable
fun CustomAppBar(
    title: String? = null,
    navigationIcon: ImageVector? = null,
    navigationAction: NavigationAction? = null
) {
    val titleText = title ?: ""
    if(navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(titleText)},
            navigationIcon = {
                IconButton(onClick = {navigationAction()}, content = {
                    Icon(imageVector = navigationIcon, contentDescription = "")
                })
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    }else{
        TopAppBar(
            title = { Text(titleText)},
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAppBarPreview() {
    Coffee4codersTheme {
        CustomAppBar("Coffee4Coders", )
    }
}