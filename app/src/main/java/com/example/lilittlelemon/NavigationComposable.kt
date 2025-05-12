package com.example.lilittlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, userData: Boolean) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(USER_DATA,Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString(FIRST_NAME, "") ?: ""
    val lastName  = sharedPreferences.getString(LAST_NAME, "") ?: ""
    val email = sharedPreferences.getString(EMAIL,  "") ?: ""
    NavHost(
        navController = navController,
        startDestination =
        if (firstName.isBlank()
            && lastName.isBlank()
            && email.isBlank()) Onboarding.route
        else Home.route
    ){
        composable(Onboarding.route){
            Onboarding(navController)
        }
        composable(Home.route){
            Home(navController)
        }
        composable(Profile.route){
            Profile(navController)
        }

    }
}

const val USER_DATA = "userData"
const val FIRST_NAME = "firstName"
const val LAST_NAME =  "lastName"
const val EMAIL = "email"