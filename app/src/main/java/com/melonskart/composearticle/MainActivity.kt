package com.melonskart.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.melonskart.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(
                        stringResource(R.string.article_heading),
                        stringResource(R.string.article_sub_text),
                        "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(text: String, subText: String, paragraph: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = text,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = subText,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraph,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )

    }
}

@Composable
fun TaskManager(message: String, greet: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),

            )
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Text(
            text = greet,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

    }
}


@Composable
fun Quadrant(header: String, paragraph: String, color: Color , modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = color),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = paragraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )

    }


}

@Composable
fun AllQuadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1F, fill = true)) {
            Quadrant(
                "Text composable",
                "Displays text and follows Material Design guidelines.",
                Color.Green,
                Modifier.weight(1f, fill = true)
            )
            Quadrant(
                "Text composable",
                "Displays text and follows Material Design guidelines.",
                Color.Yellow,
                Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1F)) {
            Quadrant(
                "Text composable",
                "Displays text and follows Material Design guidelines.",
                Color.Cyan,
                Modifier.weight(1f)
            )
            Quadrant(
                "Text composable",
                "Displays text and follows Material Design guidelines.",
                Color.LightGray,
                Modifier.weight(1f)
            )
        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        AllQuadrant()
    }
}