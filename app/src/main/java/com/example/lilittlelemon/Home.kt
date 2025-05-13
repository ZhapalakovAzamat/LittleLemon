package com.example.lilittlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
    ) {
    Column{
        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(0.80f)
                    .padding(start = 110.dp, end = 30.dp)
            )
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(0.70f)

                    .height(50.dp)

                    .clickable { navController.navigate(Profile.route) }
            ) }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPrev(){
    val navController = rememberNavController()
    Home(navController)
}