package com.osmeen.mvvmapp.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.osmeen.mvvmapp.navigation.ROUTE_CALCULATOR
import com.osmeen.mvvmapp.navigation.ROUTE_CUSTOMLIST
import com.osmeen.mvvmapp.navigation.ROUTE_INTENT
import com.osmeen.mvvmapp.navigation.ROUTE_LISTVIEW
import com.osmeen.mvvmapp.navigation.ROUTE_LOGIN
import com.osmeen.mvvmapp.navigation.ROUTE_REGISTER
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController:NavHostController) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Text(text = "Home Screen",
            fontFamily = FontFamily.Default,
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        },
               modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        
        ) {
            Text(
                text = "Login Up here",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                          navController.navigate(ROUTE_REGISTER)
                },
                modifier = Modifier.width(200.dp),
                    colors = ButtonDefaults.buttonColors(Color.Gray)


            ) {
                Text(
                    text = "Sign Up Here",
                    color = Color.Black,
                    fontFamily = FontFamily.Default,
                    fontSize = 20.sp
                )

            }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(ROUTE_LISTVIEW)
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(
                text = "ListView",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
                         navController.navigate(ROUTE_CUSTOMLIST)
        },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)

        ) {
            Text(
                text = "CustomList",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ROUTE_CALCULATOR)
        },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)

        ) {
            Text(
                text = "Calculator",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
                         navController.navigate(ROUTE_INTENT)
                         },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)

        ) {
            Text(
                text = "Intent",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun HomePrev() {
    HomeScreen(navController = rememberNavController())


}
