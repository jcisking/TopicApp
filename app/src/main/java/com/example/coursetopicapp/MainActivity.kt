package com.example.coursetopicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

                }
            }
        }
    }
}

@Composable
fun TopicCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(30.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.fashion),
                contentScale = ContentScale.FillHeight,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.fashion),
                    modifier = Modifier
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = "456"
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
        TopicCard()

    }
}