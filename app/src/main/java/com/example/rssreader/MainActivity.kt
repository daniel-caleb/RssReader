package com.example.rssreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rssreader.ui.theme.RSSReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val people = listOf(
            Person("John","Doe",20),
            Person("John","Doe",20),
            Person("John","Doe",20),
            Person("John","Doe",20),
            Person("John","Doe",20)
        )
        setContent {
            RSSReaderTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    LazyColumn {
                        items(people) {
//                            Text(text = it)
                            CardView(it)
                        }
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
    RSSReaderTheme {
        Greeting("Android")
    }
}

@Composable
fun CardView(person: Person){
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                contentDescription = "Photo of a user",
                modifier = Modifier.padding(100.dp)
                    .height(100.dp)
            )
            Text(
                text = person.fisrtname,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}