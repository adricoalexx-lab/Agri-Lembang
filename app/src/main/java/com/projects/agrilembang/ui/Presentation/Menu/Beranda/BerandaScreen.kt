package com.projects.agrilembang.ui.Presentation.Menu.Beranda

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.agrilembang.R
import com.projects.agrilembang.ui.Components.Card.CustomCard
import com.projects.agrilembang.ui.theme.interbold
import com.projects.agrilembang.ui.theme.intermedium
import com.projects.agrilembang.ui.theme.interregular
import com.projects.agrilembang.ui.theme.intersemibold
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun BerandaScreen(
    modifier: Modifier = Modifier
) {
    val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
    val currentDate = dateFormat.format(Date())
    Image(
        painter = painterResource(
            id = R.drawable.backgrnd),
        contentDescription = "Background"
    )
    Column(
        modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Image(
                    painter = painterResource(id = R.drawable.berandalogo),
                    contentDescription = "Beranda Logo",
                    modifier
                        .size(50.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(3.dp),
                ){
                    Text(
                        text = "Lembang Agri",
                        fontFamily = interbold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(
                        text = currentDate,
                        fontSize = 10.sp,
                        fontFamily = interregular,
                        color = Color.White
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "Notification",
                    modifier
                        .size(20.dp, 23.dp)
                )
                IconButton(
                    onClick = {

                    }) {
                    Image(painter = painterResource(
                        id = R.drawable.userpic),
                        contentDescription = "User Picture",
                        modifier
                            .size(40.dp)
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp)
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ){
            Column(
                modifier
                    .fillMaxSize()
                    .padding(top = 15.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Pantauan Suhu Kelembapan",
                    fontFamily = intersemibold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "Apr 30 - May 30",
                    fontFamily = intermedium,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                LineChart(
                    modifier
                        .height(190.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.logosuhu),
                            contentDescription = "Suhu",
                            modifier
                                .size(17.dp)
                        )
                        Text(
                            text = "Suhu",
                            fontSize = 14.sp,
                            fontFamily = intermedium,
                            color = Color.Gray
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.run { spacedBy(3.dp) }
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.logokelembapan),
                            contentDescription = "Kelembapan",
                            modifier
                                .size(17.dp)
                        )
                        Text(
                            text = "Kelembapan",
                            fontSize = 14.sp,
                            fontFamily = intermedium,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ){
            BerandaCard(icon = painterResource(
                id = R.drawable.iconsuhu),
                title = "Suhu", value = "25°C",
                modifier = modifier
                    .size(150.dp, 120.dp)
            )
            BerandaCard(icon = painterResource(id = R.drawable.iconkelembapan),
                title = "Kelembapan", value = "80°F",
                modifier = modifier
                    .size(150.dp, 120.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ){
            BerandaCard(icon = painterResource(id = R.drawable.iconbaterai),
                title = "Baterai", value = "95%",
                modifier = modifier
                    .size(150.dp, 120.dp))
            BerandaCard(icon = painterResource(id = R.drawable.iconlampu),
                title = "Lampu", value = "20 Watt",
                modifier = modifier
                    .size(150.dp, 120.dp))
        }
    }
}