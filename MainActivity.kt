package com.example.bottom_navigation_bar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottom_navigation_bar.ui.theme.Bottom_Navigation_barTheme
import com.example.bottom_navigation_bar.ui.theme.blue
import com.example.bottom_navigation_bar.ui.theme.lightBlack
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           navbar()
        }
    }
}

@Composable
fun Home() {


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green),
       contentAlignment = Alignment.Center) {
        Text(text = "Home", color = Color.White, fontSize = 20.sp)
    }


}
@Composable
fun Search() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue), contentAlignment = Alignment.Center,
        ) {
        Text(text = "Search", color = Color.White, fontSize = 20.sp)
    }


}
@Composable
fun About() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Red), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "About", color = Color.White, fontSize = 20.sp)
    }
}

