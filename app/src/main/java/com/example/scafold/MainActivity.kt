package com.example.scafold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scafold.ui.theme.ScafoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScafoldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScaffoldExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(modifier: Modifier = Modifier) {
    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                ),
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text("Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },

            )

        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black,
                contentColor = Color.White,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(modifier = Modifier.weight(1f), onClick = { /* do something */ }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                            Text(text = "Home")
                        }
                    }
                    IconButton(modifier = Modifier.weight(1f), onClick = { /* do something */ }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                            Text(text = "Create")
                        }
                    }
                    IconButton(modifier = Modifier.weight(1f), onClick = { /* do something */ }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Filled.Settings,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                            Text(text = "Settings")
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            Column(horizontalAlignment = Alignment.End) {
                Button(
                    onClick = { presses++ },
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    content = {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add",
                            tint = Color.White
                        )
                    }
                )
                Button(
                    onClick = { presses++ },
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = Modifier.padding(top = 10.dp),
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Send,
                            contentDescription = "Localized description",
                            tint = Color.White,
                            modifier = Modifier.padding(end = 18.dp, top = 10.dp, bottom = 10.dp)
                        )
                        Text("Navigate")
                    }
                )
            }
        },

    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f) // Occupies half of the screen width
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(40.dp)) {
                    items((1..10).toList()) { item ->
                        Text(
                            text = "List Item - $item",
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScafoldTheme {
        Greeting("Android")
    }
}