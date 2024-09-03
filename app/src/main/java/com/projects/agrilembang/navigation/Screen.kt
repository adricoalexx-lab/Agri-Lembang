package com.projects.agrilembang.navigation

sealed class Screen(val route: String){
    data object Splash : Screen("Splash")
    data object Login : Screen("Login")
    data object Register : Screen("Register")
    data object ForgotPassword : Screen("forgotpassword")
    data object OTP : Screen("otp")
    data object NewPassword : Screen("newpassword")
    data object Beranda : Screen("beranda")
    data object Kelembapan : Screen("kelembapan")
    data object Riwayat : Screen("riwayat")
    data object Suhu : Screen("suhu")
}
