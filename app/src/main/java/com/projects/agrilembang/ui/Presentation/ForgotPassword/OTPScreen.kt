package com.projects.agrilembang.ui.Presentation.ForgotPassword

import android.widget.Toast
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.projects.agrilembang.navigation.Screen
import com.projects.agrilembang.R
import com.projects.agrilembang.ui.Components.Button.CustomButton
import com.projects.agrilembang.ui.Components.TextField.OTPTextField
import com.projects.agrilembang.ui.theme.intermedium
import com.projects.agrilembang.ui.theme.intersemibold
import com.projects.agrilembang.ui.theme.poppinsregular
import com.projects.agrilembang.ui.theme.poppinssemibold

@Composable
fun OTPScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val otpLength by remember { mutableStateOf(6) }
    var otpCode by remember { mutableStateOf("") }
    val focusRequesters = List(otpLength) {FocusRequester()}
    val context = LocalContext.current

    Column(
        modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 25.dp, end = 25.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        IconButton(onClick = {
            navController.navigate(Screen.ForgotPassword.route){
                popUpTo(Screen.OTP.route){
                    inclusive = true
                }
            }
        },
            modifier = modifier
                .size(13.dp, 20.dp))
        {
            Image(
                painter = painterResource(id = R.drawable.backbutton),
                contentDescription = "Icon Back",
                modifier = modifier
                    .size(13.dp, 20.dp)
            )
        }
        Spacer(modifier = modifier.height(10.dp)
        )
        Text(
            text = "Periksa Email Anda",
            fontFamily = poppinssemibold,
            fontSize = 24.sp
        )
        Text(
            text = "Kami mengirimkan link reset ke azizfirdaus@gmail.com masukkan 5 digit kode yang disebutkan dalam email",
            fontFamily = poppinsregular,
            fontSize = 14.sp,
            color = Color(0xFFAEAEAE)
        )
        Spacer(modifier = modifier.height(10.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            for (i in 0 until otpLength){
                OTPTextField(
                    modifier = modifier
                        .size(49.dp),
                    value = otpCode.getOrNull(i)?.toString() ?: "",
                    onValueChange = { value ->
                        if (value.length <= 1) {
                            otpCode = otpCode.take(i) + value + otpCode.drop(i + 1)
                            if (value.isNotEmpty() && i < otpLength -1){
                                focusRequesters[i + 1].requestFocus()
                            }
                        }
                    },
                    focusRequester = focusRequesters[i],
                    onBackspacePressed = {
                        if (otpCode.getOrNull(i) == null && i > 0) {
                            focusRequesters[i - 1].requestFocus()
                        }
                    },
                    isFilled = otpCode.getOrNull(i)?.toString()?.isNotEmpty() == true
                )
            }
        }
        Spacer(modifier = modifier.height(10.dp)
        )
        CustomButton(
            onClickedAction = {
                navController.navigate(Screen.NewPassword.route){
                    popUpTo(Screen.OTP.route){
                        inclusive = true
                    }
                }
            },
            title = "Verifikasi Code",
            modifier = modifier
                .size(346.dp, 55.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
        ){
            Text(
                text = "Belum dapat emailnya?",
                fontSize = 12.sp,
                fontFamily = intermedium,
                color = Color(0xFF757575)
            )
            TextButton(
                onClick = {
                    Toast.makeText(context,"Sudah Terkirim", Toast.LENGTH_SHORT).show()
                },
                modifier = modifier
            ) {
                Text(
                    text = "Kirim ulang email",
                    fontFamily = intersemibold,
                    fontSize = 12.sp,
                    color = Color(0xFF175B36)
                )
            }
        }
    }
}