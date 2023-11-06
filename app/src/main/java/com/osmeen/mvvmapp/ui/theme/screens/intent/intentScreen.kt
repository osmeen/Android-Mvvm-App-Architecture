package com.osmeen.mvvmapp.ui.theme.screens.intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun IntentScreen(navController: NavHostController, context: Context){

    Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {

        Text(text = "INTENT SCREEN",
            fontFamily = FontFamily.Default,
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            val uri = Uri.parse("smsto:0789991831")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "How is today's weather")

            context.startActivity(intent)
                         },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "SMS",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+255789991831"))

            if (ContextCompat.checkSelfPermission(
                    context,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                context.startActivity(intent)
            }
        },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "CALL",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(context as Activity,takePictureIntent,1,null)
                         },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "CAMERA",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val simToolKitLaunchIntent =
                context.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let {
                val it = null
                context.startActivity(it)
            }
                         },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "STK",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val phone = "+255789991831"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            context.startActivity(intent)
                         },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "DIAL",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            context.startActivity(shareIntent)
                         },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "SHARE",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "othmanjmal07@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            context.startActivity(Intent.createChooser(emailIntent, "Send email..."))


        },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(
                text = "EMAIL",
                color = Color.Black,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

    }
}



@Preview
@Composable
fun IntentPrev(){
    IntentScreen(rememberNavController(), context =LocalContext.current)
}