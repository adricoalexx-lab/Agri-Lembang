package com.projects.agrilembang.ui.Presentation.Menu.Suhu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.agrilembang.ui.Presentation.Menu.Beranda.LineChart
import com.projects.agrilembang.ui.theme.intersemibold

@Composable
fun SensorLayout(
    num : Int
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
        border = CardDefaults.outlinedCardBorder(true),
        modifier = Modifier
            .size(330.dp, 270.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Sensor $num",
                fontSize = 17.sp,
                fontFamily = intersemibold
            )
            Text(
                text = "Data Realtime per 3 jam",
                fontSize = 12.sp,
                fontFamily = intersemibold,
                color = Color.Gray
            )
            LineChart()
        }
    }
}
