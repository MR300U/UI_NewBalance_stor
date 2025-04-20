package com.example.newbalance

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newbalance.data.MockData
import com.example.newbalance.ui.theme.AppDark
import com.example.newbalance.ui.theme.AppLight
import com.example.newbalance.ui.theme.AppRed
import com.example.newbalance.ui.theme.NewBalanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewBalanceTheme {

                Greeting()

            }
        }
    }
}


@Composable
fun Greeting() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppDark)
    ) {
        Column(Modifier.fillMaxSize()) {

            TopHeder()

            Text(
                text = "کلکسیون ها",
                color = AppLight,
                fontSize = 28.sp,
                textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(MockData.list.size) {
                    val item = MockData.list[it]
                    var liked by remember { mutableStateOf(item.liked) }
                    Card(
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(25.dp),
                        colors = CardColors(
                            Color.Transparent,
                            Color.Transparent,
                            Color.Transparent,
                            Color.Transparent
                        )

                    ) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(230.dp)
                            ) {

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(170.dp)
                                        .padding(15.dp)
                                        .clip(RoundedCornerShape(25.dp))
                                        .align(Alignment.BottomCenter)
                                ) {
                                    Box(
                                        Modifier
                                            .fillMaxSize()
                                            .background(AppLight)
                                            .padding(15.dp)
                                    ) {

                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .align(Alignment.BottomCenter),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.star),
                                                    contentDescription = "rate",
                                                    tint = Color.White,
                                                    modifier = Modifier.size(15.dp)
                                                )
                                                Spacer(modifier = Modifier.width(5.dp))
                                                Text(
                                                    text = item.rate.toString(),
                                                    fontSize = 12.sp,
                                                    color = Color.White
                                                )
                                            }

                                            IconButton(
                                                onClick = { liked = !liked },
                                                modifier = Modifier.size(28.dp)
                                            ) {
                                                Icon(
                                                    painter = painterResource(id = if (liked) R.drawable.heart_fill else R.drawable.heart_empty),
                                                    contentDescription = "",
                                                    tint = if (liked) AppRed else Color.White,
                                                    modifier = Modifier
                                                        .size(40.dp)
                                                        .padding(5.dp)
                                                        .clip(RoundedCornerShape(5.dp))
                                                )
                                            }


                                        }

                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(160.dp)
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .width(70.dp)
                                            .height(40.dp)
                                            .align(Alignment.BottomCenter)
                                            .shadow(15.dp, CircleShape)
                                    )

                                    Image(
                                        painter = painterResource(id = item.image),
                                        contentDescription = item.name,
                                        modifier = Modifier
                                            .width(160.dp)
                                            .rotate(45f)
                                            .align(Alignment.TopCenter)
                                            .padding(top = 65.dp, start = 25.dp)
                                    )
                                }

                            }

                            Text(text = item.name,Modifier.fillMaxWidth(),
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center)
                            Text(text = item.price ,Modifier.fillMaxWidth(),
                                color = AppLight,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }

        }
    }

}

@Composable
private fun TopHeder() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            painter = painterResource(id = R.drawable.menu_dots),
            contentDescription = "menu",
            modifier = Modifier.size(30.dp),
            tint = Color.White
        )

        Icon(
            painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
            modifier = Modifier.size(40.dp),
            tint = Color.White
        )

    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
fun GreetingPreview() {
    NewBalanceTheme {
        Greeting()
    }
}