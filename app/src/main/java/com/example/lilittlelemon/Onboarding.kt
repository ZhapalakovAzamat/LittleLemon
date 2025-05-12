package com.example.lilittlelemon

import android.content.Context
import android.widget.Toast
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

fun saveToSharedPreferences(
    context: Context,
    firstName: String,
    lastName: String,
    email: String
){
    val sharedPref = context.getSharedPreferences("userData", Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putString("firstNsme", firstName)
        putString("lastNane", lastName)
        putString("email", email)
            .apply()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(navController: NavHostController) {
    val context = LocalContext.current
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.logo
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
                text = "Let's get to know you",
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp)
            )
        }
        Box(
            modifier = Modifier
                .size(400.dp, 50.dp)
        ) {
            Text(
                text = ("Personal information"),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, start = 10.dp)
            )
        }
        Text(
            text = ("First name"),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp)
        )
        TextField(
            value = firstName,
            textStyle = TextStyle(fontSize = 20.sp),
            shape = RoundedCornerShape(10.dp),
            onValueChange = { newText -> firstName = newText },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        Text(
            text = ("Last name"),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp)
        )
        TextField(
            value = lastName,
            textStyle = TextStyle(fontSize = 20.sp),
            shape = RoundedCornerShape(10.dp),
            onValueChange = { newText -> lastName = newText },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        Text(
            text = ("Email"),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp)
        )
        TextField(
            value = email,
            textStyle = TextStyle(fontSize = 20.sp),
            shape = RoundedCornerShape(10.dp),
            onValueChange = { newText -> email = newText },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Button(
            onClick = {
                if (
                    firstName.isBlank()
                    && lastName.isBlank()
                    && email.isBlank()
                ) {
                    Toast.makeText(
                        context, context.getString(R.string.unsuccessful), Toast.LENGTH_SHORT
                    ).show()
                } else {
                    saveToSharedPreferences(
                        context, firstName, lastName, email
                    )
                    Toast.makeText(
                        context, context.getString(R.string.successful), Toast.LENGTH_SHORT
                    ).show()
                    navController.navigate(Home.route)
                }
                      },
            border = BorderStroke(1.dp, Color.Red),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFDCAB3B)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Register",
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingPrewiew(){
    val navController = rememberNavController()
    Onboarding(navController)
}