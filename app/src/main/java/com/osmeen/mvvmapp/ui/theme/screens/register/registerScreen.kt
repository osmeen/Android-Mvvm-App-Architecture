package com.osmeen.mvvmapp.ui.theme.screens.register

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
import com.osmeen.mvvmapp.navigation.ROUTE_HOME
import com.osmeen.mvvmapp.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    var username by remember { mutableStateOf( TextFieldValue()) }
    var password by remember { mutableStateOf( TextFieldValue()) }
    var email by remember { mutableStateOf( TextFieldValue()) }
    var confirmpassword by remember { mutableStateOf( TextFieldValue()) }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {

        Text(text = "REGISTER PAGE",
            fontSize = 30.sp,
            fontFamily = FontFamily.Default,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(50.dp))


        OutlinedTextField(
            value = username,
            label = {
                Text(text = "UserName", fontSize = 20.sp, color = Color.Black, fontFamily = FontFamily.Default)
            },
            onValueChange = { username = it },
            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            label = {
                Text(text = "email", fontSize = 20.sp, color = Color.Black, fontFamily = FontFamily.Default)
            },
            onValueChange = { email = it },

            )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            label = {
                Text(text = "Password", fontSize = 20.sp, color = Color.Black)
            },
            onValueChange = { password = it },

            )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmpassword,
            label = {
                Text(text = "confirm password", fontSize = 20.sp, color = Color.Black)
            },
            onValueChange = { confirmpassword = it },

            )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
                         navController.navigate(ROUTE_HOME)
        },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "Sign Up",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        Button(onClick = {
                         navController.navigate(ROUTE_LOGIN)
                         },
            modifier = Modifier.width(300.dp),
            colors = ButtonDefaults.buttonColors(Color.Red))
        {
            Text(
                text = "Have an account? Click to Login",
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun RegisterPrev() {
    RegisterScreen(rememberNavController())
}


