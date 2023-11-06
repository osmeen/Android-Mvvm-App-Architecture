package com.osmeen.mvvmapp.ui.theme.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.osmeen.mvvmapp.navigation.ROUTE_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf( TextFieldValue()) }
    var password by remember { mutableStateOf( TextFieldValue()) }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

        ) {
        Text(text = "LOGIN PAGE",
            fontSize = 30.sp,
            fontFamily = FontFamily.Default,
            color = Color.Black,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(40.dp))


        OutlinedTextField(
            value = username,
            label = {
                Text(text = "UserName",
                    fontSize = 15.sp,
                    color = Color.Black)
        },
            onValueChange = { username = it },

            )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            label = {
                Text(text = "Password",
                    fontSize = 15.sp,
                    color = Color.Black)
            },
            onValueChange = { password = it },

            )
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
                         navController.navigate(ROUTE_REGISTER)
        },
        modifier = Modifier.width(180.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
        Text(
            text = "Login",
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 20.sp
        )
    }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
                         navController.navigate(ROUTE_REGISTER)
        },
            modifier = Modifier.width(300.dp),
            colors = ButtonDefaults.buttonColors(Color.Red))
        {
            Text(
                text = "Don't have account? Click to Register  ",
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun LoginPrev() {
    LoginScreen(rememberNavController())
}
