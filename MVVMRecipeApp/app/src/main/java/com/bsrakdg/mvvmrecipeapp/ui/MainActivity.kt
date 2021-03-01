package com.bsrakdg.mvvmrecipeapp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsrakdg.mvvmrecipeapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // SetTextSpaceAndButton()
            SetImage()

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

    @Preview
    @Composable
    fun SetImage() {
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.happy_meal_small),
                    contentDescription = null,
                    modifier = Modifier
                        .height(300.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Happy Meal",
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 26.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "800 Calories",
                    style = TextStyle(
                        fontSize = 17.sp,
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "32.99 TL",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 10.sp
                    )
                )
            }
        }
    }
}
