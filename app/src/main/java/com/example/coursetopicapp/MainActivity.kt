package com.example.coursetopicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursetopicapp.data.DataSource
import com.example.coursetopicapp.model.Topic
import com.example.coursetopicapp.ui.theme.CourseTopicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseTopicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseTopicApp()
                }
            }
        }
    }
}
@Composable
fun CourseTopicApp() {
    TopicGrid()
}

@Composable
fun TopicGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2) ,
        contentPadding = PaddingValues(4.dp)
    ) {
        items(DataSource().returnListOfTopics()) { topic ->
            TopicCard(
                topic = topic,
                modifier = Modifier.padding(4.dp)
            )
            
        }
        
    }
}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.topicImage),
                contentScale = ContentScale.FillHeight,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp)
            ) {
                Text(
                    fontSize = 13.sp,
                    text = stringResource(id = topic.topicName),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(18.dp)
                    )
                    Text(
                        text = topic.numberOfCourses.toString(),
                        fontSize = 11.sp
                    )
                }
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun TopicCardPreview() {
    CourseTopicAppTheme {
        TopicCard(
            Topic(
                 R.string.fashion,
                23,
                R.drawable.fashion
            )
        )

    }
}