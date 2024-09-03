package com.projects.agrilembang.ui.Presentation.Menu.Beranda

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.agrilembang.R
import com.projects.agrilembang.ui.theme.interregular
import com.projects.agrilembang.ui.theme.intersemibold

@Composable
fun BerandaCard(
    modifier: Modifier = Modifier,
    icon : Painter,
    title : String,
    value : String
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        border = CardDefaults.outlinedCardBorder(enabled = true),
        modifier = modifier,
        colors = CardDefaults.cardColors(Color.White)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Card(
                    modifier = Modifier
                        .size(45.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = CircleShape,
                    border = CardDefaults.outlinedCardBorder(true)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = icon,
                            contentDescription = "Icon Suhu",
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
                Text(
                    text = title,
                    fontFamily = intersemibold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = value,
                    fontFamily = interregular,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }
    }
}