package com.borja.android.composetesting.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BorchxComponent(){
    var name by rememberSaveable {
        mutableStateOf("Borchx")
    }

    Column(Modifier.fillMaxSize()) {
        TextField(value = name, onValueChange = {name = it},modifier=Modifier.testTag("textFieldName"))
        Text(text = "Te llamas $name",modifier=Modifier.testTag("textGreeting"))


        Image(Icons.Default.Add, contentDescription = "superImage")
    }
}