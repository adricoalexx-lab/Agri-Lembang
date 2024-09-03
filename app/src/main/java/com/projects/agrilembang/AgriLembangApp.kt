package com.projects.agrilembang

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.projects.agrilembang.navigation.Screen
import com.projects.agrilembang.utils.BottomBar
import com.projects.agrilembang.ui.Components.BottomBar.BottomBar
import com.projects.agrilembang.ui.Presentation.ForgotPassword.ForgotPasswordScreen
import com.projects.agrilembang.ui.Presentation.ForgotPassword.NewPasswordScreen
import com.projects.agrilembang.ui.Presentation.ForgotPassword.OTPScreen
import com.projects.agrilembang.ui.Presentation.Login.LoginScreen
import com.projects.agrilembang.ui.Presentation.Menu.Beranda.BerandaScreen
import com.projects.agrilembang.ui.Presentation.Menu.Kelembapan.KelembapanScreen
import com.projects.agrilembang.ui.Presentation.Menu.Riwayat.RiwayatScreen
import com.projects.agrilembang.ui.Presentation.Menu.Suhu.SuhuScreen
import com.projects.agrilembang.ui.Presentation.Register.RegisterScreen
import com.projects.agrilembang.ui.Presentation.Splash.SplashScreen

@Composable
fun AgriLembangApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current

    Scaffold (
        bottomBar = {
            AnimatedVisibility(visible = currentRoute.BottomBar()) {
                BottomBar(navController = navController)
            }
        }
    ){
        NavHost(navController = navController,
            startDestination = Screen.Splash.route,
            modifier.padding(it)) {
            composable(Screen.Splash.route){
                SplashScreen(navController = navController)
            }
            composable(Screen.Login.route){
                LoginScreen(navController = navController)
            }
            composable(Screen.Register.route){
                RegisterScreen(navController = navController)
            }
            composable(Screen.ForgotPassword.route){
                ForgotPasswordScreen(navController = navController)
            }
            composable(Screen.OTP.route){
                OTPScreen(navController = navController)
            }
            composable(Screen.NewPassword.route){
                NewPasswordScreen(navController = navController)
            }
            composable(Screen.Beranda.route){
                BerandaScreen()
            }
            composable(Screen.Kelembapan.route){
                KelembapanScreen()
            }
            composable(Screen.Suhu.route){
                SuhuScreen()
            }
            composable(Screen.Riwayat.route){
                RiwayatScreen()
            }
        }
    }
}