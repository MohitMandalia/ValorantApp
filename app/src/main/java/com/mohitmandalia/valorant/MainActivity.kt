package com.mohitmandalia.valorant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mohitmandalia.valorant.core.presentation.components.BottomNavigationBar
import com.mohitmandalia.valorant.navigation.NavGraph
import com.mohitmandalia.valorant.ui.theme.ValorantTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantTheme {
                val navController = rememberNavController()

                Scaffold(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    bottomBar = {
                                BottomNavigationBar(
                                    navController = navController
                                )
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavGraph(navController = navController, it)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ValorantTheme {
        Greeting("Android")
    }
}