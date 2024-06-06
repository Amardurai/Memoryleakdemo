package com.example.memoryleakdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.memoryleakdemo.ui.theme.MemoryleakdemoTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(context, SecondActivity::class.java))
        context = this
    }

    companion object {
        lateinit var context: Context
    }

}

@Composable
fun MainScreen(onButtonClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = onButtonClick) {
            Text(text = "Go to Second Activity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MemoryleakdemoTheme {
        MainScreen(onButtonClick = {})
    }
}