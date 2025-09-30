package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme

class SecondActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Assignment2Theme {
                Scaffold {
                    SecondScreen(this)
                }
            }
        }
    }
}

@Composable
fun SecondScreen(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Text("Mobile Software Engineering Challenges", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(25.dp))


        Text("1. Device Fragmentation", style = MaterialTheme.typography.bodySmall)
        Text("2. Unstable and Dynamic Environment", style = MaterialTheme.typography.bodySmall)
        Text("3. Rapid Changes", style = MaterialTheme.typography.bodySmall)
        Text("4. Tool Support", style = MaterialTheme.typography.bodySmall)
        Text("5. Low Security and Privacy Awareness", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(40.dp))


        Button(
            onClick = {
                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Text("Main Activity")
        }
    }
}
