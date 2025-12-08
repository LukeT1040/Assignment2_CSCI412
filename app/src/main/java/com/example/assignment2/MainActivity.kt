package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            Assignment2Theme {
                Scaffold {
                    MainScreen(this)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1001 && grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }
    }
}

@Composable
fun MainScreen(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text("Luke Thompson", style = MaterialTheme.typography.bodyLarge)
        Text("1352162", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(40.dp))


        Button(
            onClick = {
                val permission = "com.example.assignment2.MY_DANGEROUS_PERMISSION"

                if (ActivityCompat.checkSelfPermission(activity, permission)
                    != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(
                        activity,
                        arrayOf(permission),
                        1001
                    )
                } else {
                    val intent = Intent(activity, SecondActivity::class.java)
                    activity.startActivity(intent)
                }
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        ) {
            Text("Start Second Activity (Runtime Permission)")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                val intent = Intent("com.example.assignment2.SHOW_SECOND")
                activity.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Activity Implicitly")
        }

        Button(
            onClick = {
                val intent = Intent(activity, ImageActivity::class.java)
                activity.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text("View Image Activity")
        }
    }
}
