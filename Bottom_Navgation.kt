package com.example.bottom_navigation_bar

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.w3c.dom.Text

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun  navbar() {

    var selected by remember {
        mutableStateOf("home")
    }
    val navcontroller = rememberNavController()

    Scaffold(bottomBar = {
        BottomAppBar(containerColor = Color.Black, modifier = Modifier.height(60.dp)) {
//            home screen
            IconButton(
                onClick = {
                    if (selected!="home") {

                        selected = "home"
                        navcontroller.navigate("home")
                    }
                }, Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = if (selected == "home")
                        Color.White else Color.Gray
                )
            }
//    search Screen
            IconButton(
                onClick = {
                    if(selected!="search") {
                        selected = "search"
                        navcontroller.navigate("search")
                    }
                }, Modifier.weight(1f)

            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = if (selected == "search")
                        Color.White else Color.Gray
                )
            }

            IconButton(
                onClick = {
                    if(selected!="about") {
                        selected = "about"
                        navcontroller.navigate("about")
                    }
                }, Modifier.weight(1f)

            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    tint = if (selected == "about")
                        Color.White else Color.Gray
                )
            }

        }
    })


    {

        NavHost(navController = navcontroller, startDestination = "home") {
//            navgraph implementation
            composable("home") {
                Home()
            }
            composable("search") {
                Search()
            }
            composable("about") {
                About()
            }

        }

//        Back Press handler
        val context = LocalContext.current

        var backPressTime by remember { mutableStateOf(0L) }
        BackHandler {

            if (navcontroller.currentDestination?.route!= "home") {
                selected="home"
                navcontroller.navigate("home") {
                    popUpTo(0) // Clear back stack
                }
            } else {
                if (System.currentTimeMillis() - backPressTime < 2000) {
                    (context as Activity).finish()
                } else {
                    Toast.makeText(context, "Press back again to exit", Toast.LENGTH_SHORT).show()
                    backPressTime = System.currentTimeMillis()
                }

            }
        }
    }



}

