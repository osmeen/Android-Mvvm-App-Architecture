package com.osmeen.mvvmapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.osmeen.mvvmapp.ui.theme.screens.listView.ListViewScreen
import com.osmeen.mvvmapp.ui.theme.screens.calculator.CalculatorScreen
import com.osmeen.mvvmapp.ui.theme.screens.customlist.CustomListScreen
import com.osmeen.mvvmapp.ui.theme.screens.home.HomeScreen
import com.osmeen.mvvmapp.ui.theme.screens.intent.IntentScreen
import com.osmeen.mvvmapp.ui.theme.screens.login.LoginScreen
import com.osmeen.mvvmapp.ui.theme.screens.register.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController= rememberNavController(),
               startDestination: String= ROUTE_HOME){
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination)
    {
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_LISTVIEW){
            ListViewScreen()
        }
        composable(ROUTE_CUSTOMLIST){
            CustomListScreen(navController)
        }
        composable(ROUTE_CALCULATOR){
            CalculatorScreen(navController)
        }
        composable(ROUTE_INTENT){
            IntentScreen(navController, LocalContext.current  )
        }
    }
}