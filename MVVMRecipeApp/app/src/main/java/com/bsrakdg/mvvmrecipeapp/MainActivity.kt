package com.bsrakdg.mvvmrecipeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SetUI()
        }
    }

    @Preview // needed to show design mode
    @Composable
    fun SetUI() {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Hey look some text")
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Button(onClick = {}) {
                Text(text = "CLICK HERE")
            }

        }
    }
}
