package com.projects.agrilembang.ui.Presentation.ForgotPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.projects.agrilembang.navigation.Screen
import com.projects.agrilembang.R
import com.projects.agrilembang.ui.Components.Button.CustomButton
import com.projects.agrilembang.ui.Components.TextField.CustomTextField
import com.projects.agrilembang.ui.theme.poppinsmedium
import com.projects.agrilembang.ui.theme.poppinsregular
import com.projects.agrilembang.ui.theme.poppinssemibold

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    Column(
        modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 25.dp, end = 25.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        IconButton(onClick = {
            navController.navigate(Screen.Login.route){
                popUpTo(Screen.ForgotPassword.route){
                    inclusive = true
                }
            }
        },
            modifier = modifier
                .size(13.dp, 20.dp)
            ) {
            Image(painter = painterResource(id = R.drawable.backbutton),
                contentDescription = "Icon Back",
                modifier = modifier
                    .size(13.dp, 20.dp)
            )
        }
        Spacer(modifier = modifier.height(10.dp)
        )
        Text(
            text = "Lupa Kata Sandi",
            fontFamily = poppinssemibold,
            fontSize = 24.sp,
        )
        Text(
            text = "Silakan masukkan email Anda untuk mengatur ulang kata sandi",
            fontFamily = poppinsregular,
            fontSize = 14.sp,
            color = Color(0xFFAEAEAE)
        )
        Text(
            text = "Email Anda",
            fontSize = 18.sp,
            fontFamily = poppinsmedium,
        )
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            CustomTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = "Masukkan Email Anda",
                isPassword = false,
                modifier = modifier
                    .size(346.dp, 55.dp)
            )
        }
        Spacer(modifier.height(7.dp))
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            CustomButton(
                onClickedAction = {
                    navController.navigate(Screen.OTP.route){
                        popUpTo(Screen.ForgotPassword.route){
                            inclusive = true
                        }
                    }
                }
                , title = "Perbarui Kata Sandi"
                , modifier = modifier
                    .size(346.dp, 55.dp)
            )
        }
    }
}
