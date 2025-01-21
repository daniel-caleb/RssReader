package com.example.rssreader

import android.R.attr.fontWeight
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rssreader.ui.theme.RSSReaderTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


//        val people = listOf(
//            Person("Simon", "Riley", 35),
//            Person("John", "Price", 45),
//            Person("Alex", "Mason", 40),
//            Person("Frank", "Woods", 38),
//            Person("David", "Mason", 30)
//        )

// Filter the list of people to include only those older than 35
//        val peopleFiltered = people.filter { it.age > 35 }

        val rssItems = listOf(
            RSSItem(
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "Movie",
                "1994-09-23",
                "https://www.imdb.com/title/tt0111161/",
                "Frank Darabont",
                R.drawable.sharkredemption
            ),
            RSSItem(
                "Breaking Bad",
                "A high school chemistry teacher turned methamphetamine producer partners with a former student to secure his family's future.",
                "TV Show",
                "2008-01-20",
                "https://www.imdb.com/title/tt0903747/",
                "Vince Gilligan",
                R.drawable.breakingbad
            ),
            RSSItem(
                "1984",
                "A dystopian social science fiction novel and cautionary tale about the dangers of totalitarianism.",
                "Book",
                "1949-06-08",
                "https://en.wikipedia.org/wiki/Nineteen_Eighty-Four",
                "George Orwell",
                R.drawable.nineteen
            ),
            RSSItem(
                "The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                "Movie",
                "1972-03-24",
                "https://www.imdb.com/title/tt0068646/",
                "Francis Ford Coppola",
                R.drawable.thegodfather
            ),
            RSSItem(
                "Game of Thrones",
                "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros.",
                "TV Show",
                "2011-04-17",
                "https://www.imdb.com/title/tt0944947/",
                "David Benioff, D.B. Weiss",
                R.drawable.got
            )
        )

        setContent {
            RSSReaderTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Text(
                            text = "RSS Feed",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .padding(top = 32.dp)
                                .padding(bottom = 16.dp)
                                .padding(start = 16.dp)
                                .padding(end = 16.dp),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray
                        )
                    }
                ) {

                    LazyColumn (
                        modifier = Modifier.padding(top = 80.dp)
                            .padding(start = 10.dp)
                    ) {
                        items(rssItems) {
                            RSSItemCard(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardView(person: Person){

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row {

            Image(
                painter = painterResource(id = R.drawable.codghost),
                contentDescription = "Photo of a user",
                modifier = Modifier
                    .padding(32.dp)
                    .height(150.dp)
            )
            Column {
                Text(
                    text = person.fisrtname,
                    modifier = Modifier.padding(start = 24.dp, top = 18.dp)
                )
                Text(
                    text = person.secondname,
                    modifier = Modifier.padding(24.dp)
                )
                Text(
                    text = person.age.toString(),
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    }
}

@Composable
fun RSSItemCard(rssItem: RSSItem) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = rssItem.title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(24.dp)
            )
            Image(
                painter = painterResource(id = rssItem.imageResId),
                contentDescription = "Photo of a user",
                modifier = Modifier
                    .padding(32.dp)
                    .height(250.dp)
                    .width(250.dp)
                    .fillMaxWidth()
            )
            Text(
                text = rssItem.text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = rssItem.type,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = rssItem.pubDate,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = rssItem.link,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = rssItem.author,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    RSSReaderTheme {
//        CardView(Person("John","Doe",20))
//    }
//}