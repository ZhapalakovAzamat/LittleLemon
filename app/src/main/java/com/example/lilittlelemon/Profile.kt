package com.example.lilittlelemon

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString(FIRST_NAME, "") ?: ""
    val lastName = sharedPreferences.getString(LAST_NAME, "") ?: ""
    val email = sharedPreferences.getString(EMAIL, "") ?: ""
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo
                ),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(250.dp, 80.dp)
                    .fillMaxSize()
                    .padding(20.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFF485E57))
                    .size(400.dp, 100.dp)
            ) {
                Text(
                    text = "Profile information",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp, start = 10.dp)
                )
            }
            Text(
                text = "First name",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp)
            )
            OutlinedTextField(
                value = "$firstName",
                onValueChange = {},
                textStyle = TextStyle(fontSize = 25.sp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            )
            Text(
                text = "Last name",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp)
            )
            OutlinedTextField(
                value = "$lastName",
                onValueChange = {},
                textStyle = TextStyle(fontSize = 25.sp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            )
            Text(
                text = "Email",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp)
            )

            OutlinedTextField(
                value = "$email",
                onValueChange = {},
                textStyle = TextStyle(fontSize = 25.sp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            )
            Button(
                onClick = {
                    sharedPreferences.edit().clear().apply()
                    navController.navigate(Onboarding.route) {
                        popUpTo(Onboarding.route) { inclusive = true }
                    }
                },
                border = BorderStroke(1.dp, Color(0xFFF47836)),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFDCAB3B)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Text(text = "Log out ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfilePrewiew(){
    val navController = rememberNavController()
    Profile(navController)
}